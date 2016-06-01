package com.lisao.attendancesystemclient.entity;

/**
 * Created by lisao on 2016/6/1.
 */
public class MyAttend {
    
    private long attendTime;
    private String name;

    public long getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(long attendTime) {
        this.attendTime = attendTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
