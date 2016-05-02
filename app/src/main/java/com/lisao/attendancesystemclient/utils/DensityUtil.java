package com.lisao.attendancesystemclient.utils;


import com.lisao.attendancesystemclient.app.CustomApplication;

/**
 * Created by lisao on 2015/10/28.
 * dp,px 相互转化
 */
public class DensityUtil {

    private static CustomApplication application;

    static {
        application = CustomApplication.getInstance();
    }


    public static int dip2px(float dpValue) {
        final float scale = application.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(float pxValue) {
        final float scale = application.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
