package com.lisao.attendancesystemclient.config;

import com.lisao.attendancesystemclient.app.CustomApplication;

/**
 * Created by lisao on 2016/5/2.
 * 应用常量
 */
public class ConstantValues {

    public static final String FACECORE_KEY = "07cdd18499da01e3be99853788c40037";

    //缓存目录
    public static final String CACHEDIR = CustomApplication.getInstance().getCacheDir().getPath();

    //数据相关
    public static final String DATABASE_NAME = "attendance.db";
    public static final String DATEBASE_PATH = "/data/data/" + CustomApplication.getInstance().getPackageName() + "/databases";
}
