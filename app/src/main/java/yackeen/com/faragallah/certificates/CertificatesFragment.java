package yackeen.com.faragallah.certificates;

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
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCertification;
import yackeen.com.faragallah.R;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class CertificatesFragment extends BaseFragment implements OnCertificateClickListener {

    private View view;
    @BindView(R.id.recyclerH)
    CenteringRecyclerView recyclerView;
    @BindView(R.id.desc)
    TextView desc;
    private CertificatesAdapter certificatesAdapter;
    private final String cacheTag = "GetCertificates";
    private ArrayList<GetCertification> dataList;

    public CertificatesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certificate, container, false);
        setView(view);
        setCertificatesRecycler();

        return view;

    }

    private void setCertificatesRecycler() {
        certificatesAdapter = new CertificatesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(certificatesAdapter);
    }

    @Override
    public void onCertificateClicked(int position) {
        recyclerView.center(position);
        desc.setText(Html.fromHtml(AppClass.isEnglish?dataList.get(position).getDescription():dataList.get(position).getDescription()));
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
                        updateRecycler((List<GetCertification>) Paper.book().read(cacheTag+getLang()));
                    }
                });

            }
        }).start();

    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        BaseRequestBody body = new BaseRequestBody();
        body.setLang(AppClass.isEnglish ? "en" : "ar");
        NetworkManger.GetCertification(body);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse2<GetCertification> mainResponse) {
        if (mainResponse != null) {
            List<GetCertification> response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "Categories.onDataLoad->" + response.getClass());
                updateRecycler(getSortedList(response));
            } else {
                onNullResponse();
            }
        } else onNullResponse();
        onRequestingApiListener.hideProgress();
    }

    private void onNullResponse() {
        Log.d("fawzy", "Categories.onNullResponse->" + "cache null calling api.. ");
        onRequestingApiListener.hideProgress();
//        sendRequest();
    }

    private void updateRecycler(List<GetCertification> response) {
        if (response != null) {
            dataList = new ArrayList<>(response);
            certificatesAdapter.setCertificatesArrayList(dataList);
            if (dataList.size() > 0)
                desc.setText(Html.fromHtml(dataList.get(0).getDescription()));
            Cache.cache(cacheTag, dataList);
        }
        onRequestingApiListener.hideProgress();
    }

    private List<GetCertification> getSortedList(List<GetCertification> response) {
        for (int i = 0; i < response.size() - 1; i++) {
            for (int j = i + 1; j < response.size(); j++) {
                if (response.get(j).getSortIndex() <= response.get(i).getSortIndex()) {
                    GetCertification item = response.get(i);
                    response.set(i, response.get(j));
                    response.set(j, item);
                }
            }
        }
        return response;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyCache(EmptyCacheData response) {
        Log.d("fawzy", "Categories.onEmptyCache->" + "cache empty calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }
    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }
}
