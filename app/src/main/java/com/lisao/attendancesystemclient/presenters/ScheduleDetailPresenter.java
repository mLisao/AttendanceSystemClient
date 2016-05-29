package com.lisao.attendancesystemclient.presenters;

import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.ScheduleApi;
import com.lisao.attendancesystemclient.api.TeacherApi;
import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.Teacher;
import com.lisao.attendancesystemclient.presenters.vu.ScheduleDetailView;
import com.lisao.attendancesystemclient.presenters.vu.ScheduleView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by lisao on 2016/5/29.
 */
public class ScheduleDetailPresenter extends BasePresenter<ScheduleDetailView> {

    private ScheduleApi scheduleApi;

    private TeacherApi teacherApi;

    public ScheduleDetailPresenter(ScheduleDetailView view) {
        super(view);
        scheduleApi = ApiUtil.createApi(ScheduleApi.class);
        teacherApi = ApiUtil.createApi(TeacherApi.class);
    }

    public void getTeacher(int id) {
        onNetWork(teacherApi.getTeacher(id))
                .subscribe(new Action1<Teacher>() {
                    @Override
                    public void call(Teacher teacher) {
                        getView().showDetailTeacher(teacher);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showStatus(false, throwable.getMessage());
                    }
                });
    }
}
