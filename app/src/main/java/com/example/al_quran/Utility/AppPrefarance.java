package com.example.al_quran.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefarance {
    private static final String language = "";


    private static void putString(Context context, String key, String val) {
        SharedPreferences preferences = context.getSharedPreferences("SharedPrefarence", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, val);
        editor.commit();
    }

    private static String getStringData(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences("SharedPrefarence", Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    private static String getStringDataEmpty(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences("SharedPrefarence", Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static void setLanguage(Context context, String ln) {
        putString(context, language, ln);
    }

    public static String getLanguage(Context context) {
        return getStringDataEmpty(context, language);
    }
}
