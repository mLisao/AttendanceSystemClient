package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.Student;
import com.lisao.attendancesystemclient.entity.Teacher;
import com.lisao.attendancesystemclient.presenters.AttendPresenter;
import com.lisao.attendancesystemclient.presenters.ScheduleDetailPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.presenters.vu.ScheduleDetailView;
import com.lisao.attendancesystemclient.utils.DialogUtil;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;
import com.lisao.attendancesystemclient.utils.ScheduleTimeUitl;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;
import com.lisao.lisaolibrary.logger.Logger;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.List;

/**
 * Created by lisao on 2016/5/22.
 */
@ViewBind(R.layout.acitivity_attend)
public class AttendActivity extends BaseActivity implements View.OnClickListener, AttendView, ScheduleDetailView {

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

    private AttendPresenter attendPresenter;
    private ScheduleDetailPresenter scheduleDetailPresenter;

    @Override
    protected void initValue() {
        schedule = (Schedule) getIntent().getSerializableExtra(EXTRA_ENTIY);
        toolbar.setTitle(schedule.getName());
        tv_schedule_name.setText(schedule.getName());
        StringBuilder weekBuilder = new StringBuilder();
        weekBuilder.append(schedule.getStartWeek())
                .append("---")
                .append(schedule.getEndWeek())
                .append("周 ")
                .append("周")
                .append(schedule.getWeek())
                .append(" ");
        tv_week.setText(weekBuilder.toString());

        StringBuilder addressBuilder = new StringBuilder();
        Logger.d("schedule.getStartTime()" + schedule.getStartTime());
        Logger.d("schedule.getEndTime()" + schedule.getEndTime());
        addressBuilder.append(ScheduleTimeUitl.getTime(schedule.getStartTime()))
                .append("---")
                .append(ScheduleTimeUitl.getTime(schedule.getEndTime()))
                .append(",")
                .append(schedule.getAddress());
        tv_address.setText(addressBuilder.toString());

        attendPresenter = new AttendPresenter(this);
        scheduleDetailPresenter = new ScheduleDetailPresenter(this);
        scheduleDetailPresenter.getTeacher(schedule.getTeacherId());
        setSupportToolBar(toolbar);
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
                intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, SCAN_QR_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SCAN_QR_CODE) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Schedule schedule = JSON.parseObject(result, Schedule.class);
            attendPresenter.addAttend((int) schedule.getId(), (int) PreferencesUtil.getLong(PreferencesUtil.ID, 1));
            showLoadingDialog("签到中。。。");
        }
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {
        if (isSuccess) {
            disMissDialog();
            DialogUtil.showDailog(mContext, "签到提示", "签到成功", null, null);
        } else {
            disMissDialog();
            showSnackBar(btn_qr_code, msg);
        }
    }

    @Override
    public void showDetailSchedule(Schedule schedule) {

    }

    @Override
    public void showDetailTeacher(Teacher teacher) {
        tv_schedule_teacher_name.setText(teacher.getName());
    }


    @Override
    public void showMyAttend(List<MyAttend> attends) {

    }

    @Override
    public void showAttendStudent(List<Student> students) {

    }
}
