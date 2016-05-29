package com.lisao.attendancesystemclient.entity;


import com.lisao.lisaolibrary.entity.BaseEntity;

import java.util.Date;

/**
 * Created by lisao on 2016/1/8.
 * 课堂信息
 */
public class Schedule extends BaseEntity {

    private String name;//课程名字
    private long startTime;//上课开始时间
    private long endTime;//上课结束时间
    private long endAttendTime;//结束签到时间
    private int week;//当前周数
    private String address;//上课地点
    private int teacherId;//代课老师
    private int startWeek;//开始周数
    private int endWeek;//结束周数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }
}
