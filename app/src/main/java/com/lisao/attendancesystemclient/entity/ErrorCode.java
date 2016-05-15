package com.lisao.attendancesystemclient.entity;

/**
 * Created by lisao on 2016/5/2.
 */
public class ErrorCode {

    public static final int SUCCESS = 0;
    public static final int FAILURE = -1;

    private int code;
    private String msg;

    public ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
