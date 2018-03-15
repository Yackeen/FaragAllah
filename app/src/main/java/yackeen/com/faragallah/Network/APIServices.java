package yackeen.com.faragallah.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yackeen.com.faragallah.BuildConfig;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.BASE_URL;

/**
 * Created by Abdelrhman Walid on 4/25/2017.
 */

public class APIServices {

    private static OkHttpClient httpClient;
    private static Retrofit retrofit;
    private static Gson gson;
    private static RequestsInterface mService;

    static Retrofit retrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson()))
                    .callFactory(httpClient())
                    .build();
        }
        return retrofit;
    }



    private static OkHttpClient httpClient() {
        if (httpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(logging);
            }
            httpClient = builder
                    .addInterceptor(new CheckInternetInterceptor())
                    .build();
        }
        return httpClient;
    }
    private static Gson gson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .create();
        }
        return gson;
    }
    static RequestsInterface GetService() {
        if (mService == null)
            mService = retrofit().create(RequestsInterface.class);
        return mService;
    }

}
