package yackeen.com.faragallah.Network.RetrofitModels.Base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abdelrhman Walid on 7/3/2017.
 */

public class BaseResponse<T extends EmptyResponseObject> {
    @SerializedName(value = "isSuccess", alternate = "Success")
    @Expose
    private boolean success = true;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("Response")
    @Expose
    private T response;
    @SerializedName("errorCode")
    @Expose
    private int errorCore;

    public int getErrorCore() {
        return errorCore;
    }

    public BaseResponse setErrorCore(int errorCore) {
        this.errorCore = errorCore;
        return this;
    }

    public T getResponse() {
        return response;
    }

    public BaseResponse setResponse(T response) {
        this.response = response;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public BaseResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public BaseResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
