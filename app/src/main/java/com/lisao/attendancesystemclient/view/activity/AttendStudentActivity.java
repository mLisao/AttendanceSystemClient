package com.lisao.attendancesystemclient.view.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.adapter.AttendStudentAdapter;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.entity.Student;
import com.lisao.attendancesystemclient.presenters.AttendPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

import java.util.List;

/**
 * Created by lisao on 2016/6/3.
 */

@ViewBind(R.layout.activity_attend_student)
public class AttendStudentActivity extends BaseActivity implements AttendView {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.recylerview)
    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private AttendStudentAdapter mAdapter;

    private AttendPresenter presenter;


    @Override
    protected void initValue() {
        toolbar.setTitle("所有签到的学生");
        setSupportToolBar(toolbar);
        mAdapter = new AttendStudentAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        presenter = new AttendPresenter(this);
        presenter.getAttendStudent(1);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showMyAttend(List<MyAttend> attends) {

    }

    @Override
    public void showAttendStudent(List<Student> students) {
        mAdapter.addData(students);
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {
        showSnackBar(toolbar, msg);
    }
}
