package com.lisao.attendancesystemclient.entity.facecore;

import java.util.List;

//人脸检测请求结果
public class FaceDetectResult {
    private FaceModel[] facemodels;

    public FaceModel[] getFacemodels() {
        return facemodels;
    }

    public void setFacemodels(FaceModel[] facemodels) {
        this.facemodels = facemodels;
    }

    @Override
    public String toString() {
        return "FaceDetectResult [facemodels=" + facemodels + "]";
    }

}
