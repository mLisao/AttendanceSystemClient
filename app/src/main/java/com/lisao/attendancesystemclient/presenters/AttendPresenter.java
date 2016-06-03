package com.lisao.attendancesystemclient.presenters;

import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.AttendApi;
import com.lisao.attendancesystemclient.entity.Attend;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.entity.Student;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;
import com.lisao.lisaolibrary.http.factory.ApiFactory;
import com.lisao.lisaolibrary.logger.Logger;

import java.util.Date;
import java.util.List;

import rx.functions.Action1;

/**
 * Created by lisao on 2016/5/28.
 */
public class AttendPresenter extends BasePresenter<AttendView> {
    private AttendApi attendApi;

    public AttendPresenter(AttendView view) {
        super(view);
        attendApi = ApiUtil.createApi(AttendApi.class);
    }

    public void addAttend(int scheduleId, int studentId) {
        Attend attend = new Attend();
        attend.setAttendTime(new Date());
        attend.setScheduleId(scheduleId);
        attend.setStudentId(studentId);
        onNetWork(attendApi.addAttend(attend))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e("addAttend call" + s);
                        getView().showStatus(true, "签到成功！");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("addAttend throwable " + throwable);
                        getView().showStatus(false, "签到失败！");
                    }
                });
    }

    public void getMyAttend() {
        long id = PreferencesUtil.getLong(PreferencesUtil.ID, 1);
        onNetWork(attendApi.getMyAttend(id))
                .subscribe(new Action1<List<MyAttend>>() {
                    @Override
                    public void call(List<MyAttend> attends) {
                        getView().showMyAttend(attends);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showStatus(false, throwable.getMessage());
                    }
                });
    }


    public void getAttendStudent(int id) {
        onNetWork(attendApi.getAttendStudeng(id))
                .subscribe(new Action1<List<Student>>() {
                    @Override
                    public void call(List<Student> students) {
                        getView().showAttendStudent(students);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showStatus(false, throwable.getMessage());
                    }
                });
    }
}
