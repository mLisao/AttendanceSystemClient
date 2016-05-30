package com.lisao.attendancesystemclient.entity.facecore;

/**
 * Created by lisao on 2016/5/30.
 */
public class FaceRequest {
    private String faceid;//人脸id
    private String nick;//昵称
    private String base64feature;//图片特征值
    private String base64faceimage;//图片base64值

    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getBase64feature() {
        return base64feature;
    }

    public void setBase64feature(String base64feature) {
        this.base64feature = base64feature;
    }

    public String getBase64faceimage() {
        return base64faceimage;
    }

    public void setBase64faceimage(String base64faceimage) {
        this.base64faceimage = base64faceimage;
    }
}
