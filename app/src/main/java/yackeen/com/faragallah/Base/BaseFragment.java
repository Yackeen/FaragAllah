package yackeen.com.faragallah.Base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import yackeen.com.faragallah.Home.OnFragmentInteractionListener;
import yackeen.com.faragallah.Home.OnRequestingApiListener;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.RetrofitModels.Requests.EmptyBody;


public class BaseFragment extends Fragment {
    private boolean active;
    public OnFragmentInteractionListener onFragmentInteractionListener;
    private Unbinder unbinder;
    private View view;
    public OnRequestingApiListener onRequestingApiListener;

    public void setView(View view) {
        this.view = view;
        unbinder = ButterKnife.bind(this, view);
    }

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
            onRequestingApiListener= (OnRequestingApiListener) context;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
        EventBus.getDefault().unregister(this);
    }

    public boolean isActive() {
        return active;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoad(EmptyBody mainResponse) {
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoInternet(NoInternetEvent event) {
//        Toast.makeText(this, getResources().getString(R.string.connection_problem), Toast.LENGTH_LONG).show();
        readPaper();
        Log.d("fawzy.BaseAct","onNoInternet");
        if (onRequestingApiListener!=null)
            onRequestingApiListener.hideProgress();
    }

    public void readPaper() {
    }

}
