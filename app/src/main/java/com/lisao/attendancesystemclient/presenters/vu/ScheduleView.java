package com.lisao.attendancesystemclient.presenters.vu;

import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.Teacher;

import java.util.List;

/**
 * Created by lisao on 2016/5/29.
 */
public interface ScheduleView extends BaseVu {
    /**
     * 显示所有有的课表列表
     *
     * @param schedules
     */
    void showSchedule(List<Schedule> schedules);
}
