package com.lisao.attendancesystemclient.app;

import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.lisao.attendancesystemclient.BuildConfig;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;


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
        initStetho();
        initPreferences();
    }

    /***
     * 初始化数据访问
     */
    private void initPreferences() {
        PreferencesUtil.init(this);
    }

    /**
     * 初始化网络调试工具
     * 访问方式:chrome://inspect
     */
    private void initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());
        }
    }
}
