package com.lisao.attendancesystemclient.view.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/5/30.
 * 我的签到
 */
@ViewBind(R.layout.activity_my_attend)
public class MyAttendActivity extends BaseActivity {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.recylerview)
    private RecyclerView recyclerView;


    @Override
    protected void initValue() {
        toolbar.setTitle("我的签到");
    }

    @Override
    protected void setListener() {

    }

}