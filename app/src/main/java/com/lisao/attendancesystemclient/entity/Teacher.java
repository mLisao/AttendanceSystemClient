package com.lisao.attendancesystemclient.entity;


import com.lisao.lisaolibrary.entity.BaseEntity;

/**
 * Created by lisao on 2016/1/8.
 */
public class Teacher extends BaseEntity {

    private long number;//工号
    private String name;//姓名
    private long mobileNumber;//手机号码
    private String email;//邮箱
    private String password;//密码

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
