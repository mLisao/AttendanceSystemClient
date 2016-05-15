package com.lisao.attendancesystemclient.entity;


import com.lisao.lisaolibrary.entity.BaseEntity;

/**
 * Created by lisao on 2016/5/15.
 * 签到表
 */
public class Attend extends BaseEntity {
    private int StudentId;
    private long attendTime;
    private int classRoomId;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public long getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(long attendTime) {
        this.attendTime = attendTime;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }
}
