package yackeen.com.faragallah.Brands;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Helpers.ImageLoader.ImageLoader;
import yackeen.com.faragallah.Home.MainActivity;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.NetworkManger;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.GetSubCategoriesBody;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCategories;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetSubCategories;
import yackeen.com.faragallah.R;

import static io.paperdb.Paper.book;
import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class BrandsFragment extends BaseFragment implements OnBrandClickListener {

    private View view;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.categoryImage)
    CircleImageView categoryImageView;
    @BindView(R.id.categoryName)
    TextView categoryNameTV;
    private BrandsAdapter brandsAdapter;
    private int category_id;
    private ArrayList<GetSubCategories> dataList;
    private final StringBuffer cacheTag = new StringBuffer("GetBrandsOf");

    public static BrandsFragment newInstance(int category_id) {
        BrandsFragment fragment = new BrandsFragment();
        Bundle args = new Bundle();
        args.putInt("id", category_id);
        fragment.setArguments(args);
        return fragment;
    }

    public BrandsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category_id = getArguments().getInt("id");
        cacheTag.append(category_id);
//        cacheTag.append(getLang());
        Log.d("fawzy", "Brands.cacheTag= " + cacheTag.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_brands, container, false);
        setView(view);
        setRecycler();
        return view;

    }
    @Override
    public void onStart() {
        super.onStart();
        getData();
    }
    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        brandsAdapter = new BrandsAdapter(this, linearLayoutManager.findLastVisibleItemPosition());
        recyclerView.setAdapter(brandsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @OnClick(R.id.category)
    void onCategoryClicked() {
        getActivity().onBackPressed();
    }

    private void getData() {
        if (NetworkHelper.getNetworkState(getActivity()))
            sendRequest();
        else readPaper();

    }

    @Override
    public void readPaper() {
        onRequestingApiListener.showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onDataLoad((BaseResponse2<GetSubCategories>) Paper.book().read(cacheTag.toString()+getLang()));
                    }
                });

            }
        }).start();

    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        GetSubCategoriesBody body = new GetSubCategoriesBody();
        body.setCategoryID(category_id);
        body.setLang(AppClass.isEnglish ? "en" : "ar");
        NetworkManger.GetSubCategories(body);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse2<GetSubCategories> mainResponse) {
        if (mainResponse != null) {
            List<GetSubCategories> response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "Brands.onDataLoad->" + response.toString());
                updateRecycler(response);
                Cache.cache(cacheTag.toString(), mainResponse);
//                cache(cacheTag.toString(), mainResponse);
            } else {
                onNullResponse();
            }
        } else onNullResponse();
        onRequestingApiListener.hideProgress();
    }

    private void onNullResponse() {
        Log.d("fawzy", "Brands.onNullResponse->" + "cache null calling api.. ");
        onRequestingApiListener.hideProgress();
//        sendRequest();
    }

    private void updateRecycler(List<GetSubCategories> response) {
        dataList = new ArrayList<>(response);
        brandsAdapter.setDataList(dataList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyCache(EmptyCacheData response) {
        Log.d("fawzy", "Brands.onEmptyCache->" + "cache empty calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }

    @Override
    public void onBrandClicked(int position) {
        onFragmentInteractionListener.onFragmentInteraction(R.id.products, category_id, dataList.get(position).getID());
    }

    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoInternet(NoInternetEvent event) {
//        Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        Log.d("fawzy.brands", "onNoInternet");
        onRequestingApiListener.hideProgress();
        readPaper();
    }
}
