package com.lisao.attendancesystemclient.entity.facecore;

import java.util.List;

//人脸检测请求结果
public class FaceDetectResult {
	private List<FaceModel> facemodels;

	public List<FaceModel> getFacemodels() {
		return facemodels;
	}

	public void setFacemodels(List<FaceModel> facemodels) {
		this.facemodels = facemodels;
	}

	@Override
	public String toString() {
		return "FaceDetectResult [facemodels=" + facemodels + "]";
	}

}
