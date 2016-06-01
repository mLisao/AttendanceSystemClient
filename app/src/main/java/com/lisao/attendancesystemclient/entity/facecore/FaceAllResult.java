package com.lisao.attendancesystemclient.entity.facecore;

import java.util.List;

/**
 * Created by lisao on 2016/5/31.
 */
public class FaceAllResult {

    private List<Face> personfaces;

    public List<Face> getPersonfaces() {
        return personfaces;
    }

    public void setPersonfaces(List<Face> personfaces) {
        this.personfaces = personfaces;
    }

    public class Face {
        private String createtime;

        private String nick;

        private String appkey;

        private String faceid;

        private String base64faceimage;

        private String base64feature;

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

        @Override
        public String toString() {
            return "ClassPojo [createtime = " + createtime + ", nick = " + nick + ", appkey = " + appkey + ", faceid = " + faceid + ", base64faceimage = " + base64faceimage + ", base64feature = " + base64feature + "]";
        }
    }
}
