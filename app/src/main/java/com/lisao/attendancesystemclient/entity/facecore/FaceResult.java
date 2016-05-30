package com.lisao.attendancesystemclient.entity.facecore;

/**
 * Created by lisao on 2016/5/30.
 */
public class FaceResult {
    private boolean result;
    private String message;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
