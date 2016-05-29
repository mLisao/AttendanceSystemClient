package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.presenters.AttendPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.utils.DialogUtil;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;
import com.lisao.lisaolibrary.logger.Logger;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by lisao on 2016/5/22.
 */
@ViewBind(R.layout.acitivity_attend)
public class AttendActivity extends BaseActivity implements View.OnClickListener, AttendView {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.btn_qr_code)
    private IOSButton btn_qr_code;

    @ViewBind(R.id.tv_schedule_name)
    private TextView tv_schedule_name;

    @ViewBind(R.id.tv_schedule_teacher_name)
    private TextView tv_schedule_teacher_name;

    @ViewBind(R.id.tv_week)
    private TextView tv_week;

    @ViewBind(R.id.tv_address)
    private TextView tv_address;

    private static final int SCAN_QR_CODE = 1;

    public static final String EXTRA_ENTIY = "entity";

    private Schedule schedule;

    private AttendPresenter presenter;

    @Override
    protected void initValue() {
        schedule = (Schedule) getIntent().getSerializableExtra(EXTRA_ENTIY);
        toolbar.setTitle(schedule.getName());
        tv_schedule_name.setText(schedule.getName());
        tv_schedule_teacher_name.setText(schedule.getTeacherId() + "");
        presenter = new AttendPresenter(this);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void setListener() {
        btn_qr_code.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_qr_code:
                presenter.addAttend(1, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SCAN_QR_CODE) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
        }
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }
}
