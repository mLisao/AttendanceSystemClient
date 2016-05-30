package com.lisao.attendancesystemclient.entity.facecore;

/**
 * Created by lisao on 2016/5/30.
 */
public class FaceSimilarRequest {
    private String base64feature;//目标人脸的特征值
    private float threshold;//阈值
    private int maxresult;//最大返回人脸个数

    public String getBase64feature() {
        return base64feature;
    }

    public void setBase64feature(String base64feature) {
        this.base64feature = base64feature;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public int getMaxresult() {
        return maxresult;
    }

    public void setMaxresult(int maxresult) {
        this.maxresult = maxresult;
    }
}
