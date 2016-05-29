package com.lisao.attendancesystemclient.presenters;

import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.ScheduleApi;
import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.presenters.vu.ScheduleView;
import com.lisao.lisaolibrary.logger.Logger;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by lisao on 2016/5/29.
 */
public class SchedulePresenter extends BasePresenter<ScheduleView> {

    private ScheduleApi scheduleApi;

    public SchedulePresenter(ScheduleView view) {
        super(view);
        scheduleApi = ApiUtil.createApi(ScheduleApi.class);
    }

    public void getAllSchedule() {
        onNetWork(scheduleApi.getAllSchedule())
                .subscribe(new Action1<List<Schedule>>() {
                    @Override
                    public void call(List<Schedule> schedules) {
                        getView().showSchedule(schedules);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showStatus(false, throwable.getMessage());
                    }
                });
    }
}
