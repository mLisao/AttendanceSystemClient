package com.lisao.attendancesystemclient.presenters;

import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.AttendApi;
import com.lisao.attendancesystemclient.entity.Attend;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.lisaolibrary.http.factory.ApiFactory;
import com.lisao.lisaolibrary.logger.Logger;

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

    public void addAttend(int classRoomId, int studentId) {
        Attend attend = new Attend();
        attend.setAttendTime(System.currentTimeMillis());
        attend.setClassRoomId(classRoomId);
        attend.setStudentId(studentId);
        onNetWork(attendApi.addAttend(attend))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e("addAttend call" + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("addAttend throwable " + throwable);

                    }
                });
    }
}