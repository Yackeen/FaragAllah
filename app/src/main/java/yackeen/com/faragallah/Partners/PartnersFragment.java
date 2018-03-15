package yackeen.com.faragallah.Partners;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mightyfrog.widget.CenteringRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.paperdb.Paper;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.NetworkManger;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseRequestBody;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse2;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCustomers;
import yackeen.com.faragallah.R;
import yackeen.com.faragallah.certificates.OnCertificateClickListener;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class PartnersFragment extends BaseFragment implements OnCertificateClickListener {

    private View view;
    private final int AnimationDuration = 500;
    private Continent continent;
    private final String cacheTag = "GetCustomers";
    private ArrayList<GetCustomers> dataList;
    private PartnersAdapter adapter;
    @BindView(R.id.recyclerH)
    CenteringRecyclerView recyclerView;
    @BindView(R.id.desc)
    TextView desc;

    public PartnersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_partners, container, false);
        setView(view);
        setRecycler();
        return view;

    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new PartnersAdapter(this, linearLayoutManager.findLastVisibleItemPosition());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
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
                        updateRecycler((List<GetCustomers>) Paper.book().read(cacheTag+getLang()));
                    }
                });
            }
        }).start();

    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        BaseRequestBody body = new BaseRequestBody();
        body.setLang(AppClass.isEnglish ? "en" : "ar");
        NetworkManger.GetCustomers(body);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse2<GetCustomers> mainResponse) {
        if (mainResponse != null) {
            List<GetCustomers> response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "Customers.onDataLoad->size= " + response.size());
                updateRecycler(getSortedCustomers(response));
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

    private void updateRecycler(List<GetCustomers> response) {
        if (response != null) {
            dataList = new ArrayList<>(response);
            adapter.setCustomersArrayList(dataList);
            Cache.cache(cacheTag, dataList);
            try {
                desc.setText(Html.fromHtml(response.get(0).getDescription()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        onRequestingApiListener.hideProgress();

    }

    private List<GetCustomers> getSortedCustomers(List<GetCustomers> response) {
        for (int i = 0; i < response.size() - 1; i++) {
            for (int j = i + 1; j < response.size(); j++) {
                if (Integer.parseInt(response.get(j).getSortIndex()) <= Integer.parseInt(response.get(i).getSortIndex())) {
                    GetCustomers item = response.get(i);
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
    public void onCertificateClicked(int position) {
       try {
           desc.setText(Html.fromHtml(dataList.get(position).getDescription()));
       }catch (Exception e){
           e.printStackTrace();
       }
        recyclerView.center(position);
    }

    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }
    enum Continent {
        ACIA,
        AFRICA,
        AUSTRALIA,
        SOUTH_AMERICA,
        NORTH_AMERICA,
        EUROPE
    }
}
