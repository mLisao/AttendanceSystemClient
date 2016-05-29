package com.lisao.attendancesystemclient.entity;


import com.lisao.lisaolibrary.entity.BaseEntity;

import java.util.Date;

/**
 * Created by lisao on 2016/5/15.
 * 签到表
 */
public class Attend extends BaseEntity {
    private int StudentId;
    private Date attendTime;
    private int scheduleId;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
