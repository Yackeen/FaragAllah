package yackeen.com.faragallah.Network.RetrofitModels.Base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abdelrhman Walid on 7/3/2017.
 */

public class BaseResponse2<T extends EmptyResponseObject> {
    @SerializedName(value = "isSuccess", alternate = "Success")
    @Expose
    private boolean success = true;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("errorCode")
    @Expose
    private int errorCore;
    @SerializedName("Response")
    @Expose
    private List<T> response;

    public List<T> getResponse() {
        return response;
    }

    public void setResponse(List<T> response) {
        this.response = response;
    }

    public int getErrorCore() {
        return errorCore;
    }

    public BaseResponse2 setErrorCore(int errorCore) {
        this.errorCore = errorCore;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public BaseResponse2 setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public BaseResponse2 setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
