package com.lisao.attendancesystemclient.entity.facecore;

//人脸对比请求结果
public class FaceCompareResult {
	private float similar;

	public float getSimilar() {
		return similar;
	}

	public void setSimilar(float similar) {
		this.similar = similar;
	}

	@Override
	public String toString() {
		return "FaceDetectResult [similar=" + similar + "]";
	}
	

}
