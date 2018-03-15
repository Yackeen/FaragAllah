package yackeen.com.faragallah.Network;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import yackeen.com.faragallah.Home.MainActivity;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.NO_INTERNET;

/**
 * Created by Abdelrhman Walid on 6/7/2017.
 */

class CheckInternetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (NetworkHelper.getNetworkState(MainActivity.getInstance())) {
            return chain.proceed(chain.request());
        }
        return new Response.Builder()
                .request(chain.request())
                .code(NO_INTERNET)
                .protocol(Protocol.HTTP_1_1)
                .body(ResponseBody.create(null, ""))
                .message("No Internet")
                .build();
    }
}
