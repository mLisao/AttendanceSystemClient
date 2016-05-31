package com.lisao.attendancesystemclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lisao on 2016/5/31.
 */
public class PreferencesUtil {
    private static SharedPreferences preferences;
    private static final String ATTENDCLIENT = "attendclient";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    public static final String IS_LOGIN = "login";
    public static final String IS_TEACHER = "teacher";

    private PreferencesUtil() {
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        preferences = context.getSharedPreferences(ATTENDCLIENT, Context.MODE_PRIVATE);
    }

    public static void putInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public static void putLong(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public static String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }
}
