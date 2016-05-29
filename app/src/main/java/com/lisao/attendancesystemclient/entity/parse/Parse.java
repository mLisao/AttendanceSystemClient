package com.lisao.attendancesystemclient.entity.parse;

import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.TimeTableModel;
import com.lisao.attendancesystemclient.utils.ScheduleTimeUitl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisao on 2016/5/19.
 */
public class Parse {
    /**
     * 转换所需的数据
     *
     * @param schedule
     * @return
     */
    public static TimeTableModel parse(Schedule schedule) {
        TimeTableModel model = new TimeTableModel();
        model.setName(schedule.getName());
        model.setStartnum(ScheduleTimeUitl.getNum(schedule.getStartTime()));
        model.setEndnum(ScheduleTimeUitl.getNum(schedule.getEndTime()));
        model.setClassroom(schedule.getAddress());
        model.setWeek(schedule.getWeek());
        model.setSchedule(schedule);
        return model;
    }

    /**
     * 列表数据转换
     *
     * @param schedules
     * @return
     */
    public static List<TimeTableModel> parse(List<Schedule> schedules) {
        List<TimeTableModel> models = new ArrayList<>();
        for (Schedule schedule : schedules) {
            models.add(parse(schedule));
        }
        return models;
    }
}
