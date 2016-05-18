package com.lisao.attendancesystemclient.entity.facecore;
//人脸检测请求
public class FaceDetectRequest {
	private String faceimage;
	
	public String getFaceImage(){
		return faceimage;
	}
	
	public void setFaceImage(String faceImage){
		faceimage=faceImage;
	}
}
