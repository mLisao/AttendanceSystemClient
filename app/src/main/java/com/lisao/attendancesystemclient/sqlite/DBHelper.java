package com.lisao.attendancesystemclient.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lisao.attendancesystemclient.config.ConstantValues;


/**
 * Created by lisao on 2015/11/30.
 */
public class DBHelper extends SQLiteOpenHelper {

    //    数据库的当前版本
    private static final int CURRENT_VERSION = 1;
    private static final String TAG = "DBHelper";

    public DBHelper(Context context) {
        super(context, ConstantValues.DATABASE_NAME, null, CURRENT_VERSION);
    }

    //创建数据库
//    数据库第一次创建的时候才会执行
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
