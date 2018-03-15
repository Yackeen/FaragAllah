package yackeen.com.faragallah.Network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.IOException;

import yackeen.com.faragallah.R;

/**
 * Created by elmar7om on 29/12/2017.
 */

public class NetworkHelper {
    public static boolean getNetworkState(Activity activity) {
        boolean network, online;
        network = networkAvailable(activity);
        online = isOnline();
        if (network && online)
            return true;
        if (!network) {
            Log.d("fawzy", "NetworkHelper.getNetworkState->connection_problem");
//            showToast(activity, activity.getResources().getString(R.string.connection_problem));
        } else if (!online) {
            Log.d("fawzy", "NetworkHelper.getNetworkState->offline_problem");
//            showToast(activity, activity.getResources().getString(R.string.offline_problem));
        }
        return false;

    }

    private static void showToast(final Activity activity, final String msg) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean getNetworkState(Activity activity, View view) {
        boolean network, online;
        network = networkAvailable(activity);
        online = isOnline();
        if (network && online)
            return true;
        try {
            if (!network)
                Snackbar.make(view, activity.getResources().getString(R.string.connection_problem), Snackbar.LENGTH_LONG).show();
            else if (!online)
                Snackbar.make(view, activity.getResources().getString(R.string.offline_problem), Snackbar.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            getNetworkState(activity);
        }
        return false;
    }

    private static Boolean networkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
