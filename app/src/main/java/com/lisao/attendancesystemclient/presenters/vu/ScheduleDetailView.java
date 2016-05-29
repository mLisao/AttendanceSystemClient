package com.lisao.attendancesystemclient.presenters.vu;

import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.Teacher;
import com.lisao.attendancesystemclient.presenters.vu.BaseVu;

/**
 * Created by lisao on 2016/5/29.
 */
public interface ScheduleDetailView extends BaseVu {

    /**
     * 获取课表的详情
     *
     * @param schedule
     */
    void showDetailSchedule(Schedule schedule);

    /**
     * 获取老师的详情
     *
     * @param teacher
     */
    void showDetailTeacher(Teacher teacher);
}
