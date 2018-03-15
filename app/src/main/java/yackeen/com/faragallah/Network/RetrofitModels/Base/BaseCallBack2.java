package yackeen.com.faragallah.Network.RetrofitModels.Base;


import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.net.SocketTimeoutException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yackeen.com.faragallah.Network.Events.CompleteEvent;
import yackeen.com.faragallah.Network.Events.FailEvent;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.Events.UnAuthErrorEvent;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.GetCategories;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.NO_INTERNET;

/**
 * Created by Abdelrhman Walid on 4/25/2017.
 */

public class BaseCallBack2<T extends EmptyResponseObject> implements Callback<BaseResponse2<T>> {

    public static final String TAG = BaseCallBack2.class.getSimpleName();

    @Override
    public void onResponse(Call<BaseResponse2<T>> call, Response<BaseResponse2<T>> response) {
        if (checkInternet(response) && response.isSuccessful()) {
            verifyResponse(response.body());
            complete();
        } else if (!response.isSuccessful() && response.code() == 401) {
            EventBus.getDefault().post(new UnAuthErrorEvent());
        }
    }

    @Override
    public void onFailure(Call<BaseResponse2<T>> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            EventBus.getDefault().post(new NoInternetEvent());
        } else {
            handleFail(t.getMessage());
        }
        complete();
    }

    protected boolean checkInternet(Response<BaseResponse2<T>> response) {
        if (response.code() == NO_INTERNET) {
            EventBus.getDefault().post(new NoInternetEvent());
            complete();
            return false;
        }
        return true;
    }

    protected void verifyResponse(BaseResponse2<T> response) {
        if (response == null)
            handleFail((String) null);
        else if (response.isSuccess()) {
            handleSuccess(response);
        } else
            handleFail(response);
    }

    protected void handleSuccess(BaseResponse2<T> response) {
        if (response != null) {
            EventBus.getDefault().post(response);
        }
    }

    private boolean isCategory(BaseResponse2<T> response) {
        try {
            BaseResponse2<GetCategories> categoryResponse=(BaseResponse2<GetCategories>) response;
            EventBus.getDefault().post(categoryResponse);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void handleFail(BaseResponse2 response) {
        EventBus.getDefault().post(new FailEvent(response.getErrorMessage()));
        if (response.getErrorCore() == 401) {
            EventBus.getDefault().post(new UnAuthErrorEvent());
        }
    }

    protected void handleFail(String message) {
        EventBus.getDefault().post(new FailEvent(message));
    }

    protected void complete() {
        EventBus.getDefault().post(new CompleteEvent());
    }
}
