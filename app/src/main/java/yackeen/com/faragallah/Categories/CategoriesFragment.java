package yackeen.com.faragallah.Categories;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.paperdb.Paper;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.NetworkManger;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCategories;
import yackeen.com.faragallah.R;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class CategoriesFragment extends BaseFragment implements OnCategoriesClickListener {

    private View view;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    private final String cacheTag = "GetCategories";
    private ArrayList<GetCategories> dataList;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("fawzy","Categories.cacheTag= "+cacheTag.toString());
    }
    @Override
    public void onStart() {
        super.onStart();
        getData();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        setView(view);
        setRecycler();
        return view;

    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoriesAdapter = new CategoriesAdapter(this, linearLayoutManager.findLastVisibleItemPosition());
        recyclerView.setAdapter(categoriesAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    private void getData() {
        if (NetworkHelper.getNetworkState(getActivity()))
            sendRequest();
        else readPaper();

    }

    @Override
    public void readPaper() {
        Log.d("fawzy.categories","readPaperStart");
        onRequestingApiListener.showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateRecycler((List<GetCategories>) Paper.book().read(cacheTag+getLang()));
                    }
                });
            }
        }).start();
    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        BaseRequestBody body = new BaseRequestBody();
        body.setLang(AppClass.isEnglish ? "en" : "ar");
        NetworkManger.GetCategories(body);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse2<GetCategories> mainResponse) {
        if (mainResponse != null) {
            List<GetCategories> response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "Certificates.onDataLoad->" + response.getClass());
//                Cache.cache(cacheTag, mainResponse);
                updateRecycler(getSortedList(response));
            } else {
                onNullResponse();
            }
        } else onNullResponse();
        onRequestingApiListener.hideProgress();
    }

    private void onNullResponse() {
        Log.d("fawzy", "Certificates.onNullResponse->" + "cache null calling api.. ");
        onRequestingApiListener.hideProgress();
//        sendRequest();
    }

    private void updateRecycler(List<GetCategories> response) {
        if (response != null) {
            dataList = new ArrayList<>(response);
            categoriesAdapter.setCategoriesArrayList(dataList);
            Cache.cache(cacheTag, dataList);
        }
        onRequestingApiListener.hideProgress();
    }

    private List<GetCategories> getSortedList(List<GetCategories> response) {
        for (int i = 0; i < response.size() - 1; i++) {
            for (int j = i + 1; j < response.size(); j++) {
                if (response.get(j).getSortIndex() <= response.get(i).getSortIndex()) {
                    GetCategories item = response.get(i);
                    response.set(i, response.get(j));
                    response.set(j, item);
                }
            }
        }
        return response;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyCache(EmptyCacheData response) {
        Log.d("fawzy", "Certificates.onEmptyCache->" + "cache empty calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }

    @Override
    public void onCategoryClicked(int position) {
        onFragmentInteractionListener.onFragmentInteraction(R.id.brands, dataList.get(position).getID());
    }
    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoInternet(NoInternetEvent event) {
//        Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        Log.d("fawzy.categories", "onNoInternet");
       onRequestingApiListener.hideProgress();
       readPaper();
    }
}
