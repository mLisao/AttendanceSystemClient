package com.lisao.attendancesystemclient.entity;


import com.lisao.lisaolibrary.entity.BaseEntity;

/**
 * Created by lisao on 2016/1/8.
 * 课堂信息
 */
public class Classe extends BaseEntity {
    private long startTime;//上课开始时间
    private long endTime;//上课结束时间
    private long endAttendTime;//结束签到时间
    private String address;//上课地点
    private Teacher teacher;//代课老师

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndAttendTime() {
        return endAttendTime;
    }

    public void setEndAttendTime(long endAttendTime) {
        this.endAttendTime = endAttendTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
