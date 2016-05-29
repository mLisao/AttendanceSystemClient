package com.lisao.attendancesystemclient.entity;

public class TimeTableModel {
    private Schedule schedule;
    private int startnum;
    private int endnum;
    private int week;
    private String name = "";
    private String classroom = "";

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getStartnum() {
        return startnum;
    }

    public int getEndnum() {
        return endnum;
    }

    public int getWeek() {
        return week;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }

    public void setEndnum(int endnum) {
        this.endnum = endnum;
    }

    public void setWeek(int week) {
        this.week = week;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    public TimeTableModel() {
        // TODO Auto-generated constructor stub
    }

    public TimeTableModel(int startnum, int endnum, int week, String name, String classroom) {
        super();
        this.startnum = startnum;
        this.endnum = endnum;
        this.week = week;
        this.name = name;
        this.classroom = classroom;
    }

}
