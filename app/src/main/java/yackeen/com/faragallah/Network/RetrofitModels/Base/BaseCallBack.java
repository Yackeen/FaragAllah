package yackeen.com.faragallah.Network.RetrofitModels.Base;



import org.greenrobot.eventbus.EventBus;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yackeen.com.faragallah.Network.Events.CompleteEvent;
import yackeen.com.faragallah.Network.Events.FailEvent;
import yackeen.com.faragallah.Network.Events.NoInternetEvent;
import yackeen.com.faragallah.Network.Events.UnAuthErrorEvent;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.NO_INTERNET;

/**
 * Created by Abdelrhman Walid on 4/25/2017.
 */

public class BaseCallBack<T extends EmptyResponseObject> implements Callback<BaseResponse<T>> {

    public static final String TAG = BaseCallBack.class.getSimpleName();

    @Override
    public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {
        if (checkInternet(response) && response.isSuccessful()) {
            verifyResponse(response.body());
            complete();
        } else if (!response.isSuccessful() && response.code() == 401) {
            EventBus.getDefault().post(new UnAuthErrorEvent());
        }
    }

    @Override
    public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            EventBus.getDefault().post(new NoInternetEvent());
        } else {
            handleFail(t.getMessage());
        }
        complete();
    }

    protected boolean checkInternet(Response<BaseResponse<T>> response) {
        if (response.code() == NO_INTERNET) {
            EventBus.getDefault().post(new NoInternetEvent());
            complete();
            return false;
        }
        return true;
    }

    protected void verifyResponse(BaseResponse<T> response) {
        if (response == null)
            handleFail((String) null);
        else if (response.isSuccess()) {
            handleSuccess(response);
        } else
            handleFail(response);
    }

    protected void handleSuccess(BaseResponse<T> response) {
        if (response != null)
            EventBus.getDefault().post(response);
    }

    protected void handleFail(BaseResponse response) {
        EventBus.getDefault().post(new FailEvent(response.getErrorMessage()));
        if (response.getErrorCore() == 401){
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
