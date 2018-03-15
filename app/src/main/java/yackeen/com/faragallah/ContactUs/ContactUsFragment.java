package yackeen.com.faragallah.ContactUs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import io.paperdb.Paper;
import yackeen.com.faragallah.Base.BaseFragment;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Helpers.Animator;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.NetworkManger;
import yackeen.com.faragallah.Network.RetrofitModels.Base.BaseResponse;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.EmptyBody;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetContactUs;
import yackeen.com.faragallah.R;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;


public class ContactUsFragment extends BaseFragment {
    private View view;
    private final int AnimationDuration = 750, DELAY = 250;
    private final String cacheTag = "GetContactUs";
    @BindView(R.id.factory)
    LinearLayout factoryLayout;
    @BindView(R.id.headOffice)
    LinearLayout headOfficeLayout;
    @BindView(R.id.mails)
    LinearLayout mailsLayout;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        setView(view);
//        getData();
        return view;

    }

    private void animate() {
        Animator.scaleY(headOfficeLayout, AnimationDuration, DELAY, "show");
        Animator.scaleY(factoryLayout, AnimationDuration, DELAY * 2, "show");
        Animator.scaleX(mailsLayout, AnimationDuration, DELAY * 3, "show");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void getData() {
        if (NetworkHelper.getNetworkState(getActivity()))
            sendRequest();
        else
            readPaper();
    }

    public void readPaper() {
        onRequestingApiListener.showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onDataLoad((BaseResponse<GetContactUs>) Paper.book().read(cacheTag+getLang()));
                    }
                });
            }
        }).start();

    }

    private void sendRequest() {
        onRequestingApiListener.showProgress();
        NetworkManger.GetContactUs(new EmptyBody());
    }

    @Override
    public void onStart() {
        super.onStart();
        animate();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(BaseResponse<GetContactUs> mainResponse) {
        if (mainResponse != null) {
            GetContactUs response = mainResponse.getResponse();
            if (response != null) {
                Log.d("fawzy", "MainActivity.onDataLoad->" + response.getClass());
//                textView.setText(AppClass.isEnglish ? Html.fromHtml(response.getContactEn()) : Html.fromHtml(response.getContactAr()));
                Cache.cache(cacheTag, mainResponse);
            } else {
                onNullResponse();
            }
        } else onNullResponse();
        onRequestingApiListener.hideProgress();
    }

    private void onNullResponse() {
        Log.d("fawzy", "MainActivity.onNullResponse->" + "cache null calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyCache(EmptyCacheData response) {
        Log.d("fawzy", "MainActivity.onEmptyCache->" + "cache empty calling api.. ");
        onRequestingApiListener.hideProgress();
        sendRequest();
    }
    @Override
    public void onStop() {
        super.onStop();
        onRequestingApiListener.hideProgress();
    }

}
