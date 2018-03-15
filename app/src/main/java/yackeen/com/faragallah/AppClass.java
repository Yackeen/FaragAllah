package yackeen.com.faragallah;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import io.paperdb.Paper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import yackeen.com.faragallah.Cache.Cache;
import yackeen.com.faragallah.Helpers.ConstantsHolder;

import static yackeen.com.faragallah.Helpers.ConstantsHolder.KEY_LANGUAGE;

/**
 * Created by fawzy.
 */

public class AppClass extends Application {

    public static boolean isEnglish;
    private static AppClass instance;


    public static void switchLang(Context context) {
        isEnglish = !isEnglish;
        PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putBoolean(KEY_LANGUAGE, isEnglish)
                .apply();
//        Cache.cache(ConstantsHolder.KEY_LANGUAGE, isEnglish);
        Log.d("fawzy", "AppClass.switchLang.isEnglish now= " + isEnglish);
        changeFont();
    }

    private static void changeFont() {
        String fontPath;
        fontPath = "Ubuntu-Regular.ttf";
//        if (isEnglish) {
//            fontPath = "Ubuntu-Regular.ttf";
//        } else {
//            fontPath = "Ubuntu-Regular.ttf";
//        }

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(fontPath)
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }


    public static AppClass getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Paper.init(this);
        isEnglish = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(ConstantsHolder.KEY_LANGUAGE, false);
//        isEnglish = Paper.book().read(ConstantsHolder.KEY_LANGUAGE);
        Log.d("fawzy", "AppClass.onCreate.isEnglish= " + isEnglish);
        changeFont();
    }

}
