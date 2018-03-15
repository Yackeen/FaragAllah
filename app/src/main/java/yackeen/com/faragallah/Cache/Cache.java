package yackeen.com.faragallah.Cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import io.paperdb.Paper;
import yackeen.com.faragallah.AppClass;
import yackeen.com.faragallah.Home.MainActivity;
import yackeen.com.faragallah.Network.NetworkHelper;
import yackeen.com.faragallah.Network.RetrofitModels.Responses.EmptyCacheData;

import static io.paperdb.Paper.book;
import static yackeen.com.faragallah.Helpers.ConstantsHolder.KEY_PREFERENCES;
import static yackeen.com.faragallah.Helpers.ConstantsHolder.getLang;

/**
 * Created by Fawzy  on 10/2/2017.
 */

public class Cache {

    public static void clearPreferences() {
        getSharedPreference()
                .edit()
                .clear()
                .apply();
    }

    private static SharedPreferences getSharedPreference() {
        return AppClass.getInstance()
                .getSharedPreferences(
                        KEY_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void clearPaper() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Paper.book().destroy();
            }
        }).start();
    }

    public static <T> void cache(final String key, final T data) {
        Log.d("fawzy", "Cache.cache with key= " + key.toString() + "\nand data class type= " + data.toString());
        if (NetworkHelper.getNetworkState(MainActivity.getInstance()))
            new Thread(new Runnable() {
                @Override
                public void run() {
                    book().write(key + getLang(), data);
                }
            }).start();
        else Log.d("fawzy", "Cache.cache with key= " + key.toString() + "didn't complete as it's offline");
    }

    public static <T> void getCached(final String key) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                T data = Paper.book().read(key);
                if (data != null)
                    EventBus.getDefault().post(data);
                else EventBus.getDefault().post(new EmptyCacheData());
            }
        }).start();
    }

}
