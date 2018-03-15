package yackeen.com.faragallah.Helpers;

import yackeen.com.faragallah.AppClass;

/**
 * Created by elmar7om on 09/02/2018.
 */

public class ConstantsHolder {
    public static final String KEY_LANGUAGE = "Lang";
    public static final String KEY_PREFERENCES = "Pref";

    public static String getLang() {
        return AppClass.isEnglish ? "en" : "ar";
    }

    public static String Lang = "en";
    public static final String BASE_URL = "http://yakensolution.cloudapp.net/Faragello/Api/";
    public static final int NO_INTERNET = 909;
}
