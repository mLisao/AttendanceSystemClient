package com.lisao.attendancesystemclient.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by lisao on 2016/3/6.
 * 创建recyclerView manager 工厂
 */
public class RecylerViewManagerFactory {

    public static LinearLayoutManager creatVerticalManger(Context context) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    public static LinearLayoutManager creaHorizontalManger(Context context) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return manager;
    }

    public static GridLayoutManager creatVerticalGridManger(Context context, int count) {
        GridLayoutManager manager = new GridLayoutManager(context, count);
        return manager;
    }
}
