package yackeen.com.faragallah.Network.RetrofitModels.Base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abdelrhman Walid on 4/25/2017.
 */

public class BaseRequestBody {
    private static String l = "en";

    @SerializedName("lang")
    @Expose
    private String lang = l;

    public static void setLanguage(String lang) {
        l = lang;
    }

    public static String getLanguge() {
        return l;
    }

    public String getLang() {
        return lang;
    }

    public BaseRequestBody setLang(String lang) {
        this.lang = lang;
        return this;
    }

}
