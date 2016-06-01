package com.lisao.attendancesystemclient.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.adapter.MyAttendAdapter;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.presenters.AttendPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

import java.util.List;

/**
 * Created by lisao on 2016/5/30.
 * 我的签到
 */
@ViewBind(R.layout.activity_my_attend)
public class MyAttendActivity extends BaseActivity implements AttendView {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.recylerview)
    private RecyclerView recyclerView;

    private MyAttendAdapter mAdapter;

    private AttendPresenter presenter;

    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void initValue() {
        toolbar.setTitle("我的签到");
        setSupportToolBar(toolbar);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new MyAttendAdapter(this);
        presenter = new AttendPresenter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        presenter.getMyAttend();
        showLoadingDialog("加载中。。");
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }

    @Override
    public void showMyAttend(List<MyAttend> attends) {
        disMissDialog();
        mAdapter.addData(attends);
    }
}