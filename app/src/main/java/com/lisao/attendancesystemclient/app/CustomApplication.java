package com.lisao.attendancesystemclient.app;

import android.support.multidex.MultiDexApplication;


/**
 * Created by lisao on 2016/5/2.
 */
public class CustomApplication extends MultiDexApplication {
    private static CustomApplication mInstance;

    public static CustomApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
