package com.lisao.attendancesystemclient.entity.facecore;

/**
 * Created by lisao on 2016/5/30.
 */
public class SimilarResult {
    private String createtime;

    private String nick;

    private String appkey;

    private String faceid;

    private String base64faceimage;

    private String base64feature;

    private float similar;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid;
    }

    public String getBase64faceimage() {
        return base64faceimage;
    }

    public void setBase64faceimage(String base64faceimage) {
        this.base64faceimage = base64faceimage;
    }

    public String getBase64feature() {
        return base64feature;
    }

    public void setBase64feature(String base64feature) {
        this.base64feature = base64feature;
    }

    public float getSimilar() {
        return similar;
    }

    public void setSimilar(float similar) {
        this.similar = similar;
    }

    @Override
    public String toString() {
        return "ClassPojo [createtime = " + createtime + ", nick = " + nick + ", appkey = " + appkey + ", faceid = " + faceid + ", base64faceimage = " + base64faceimage + ", base64feature = " + base64feature + ", similar = " + similar + "]";
    }
}
