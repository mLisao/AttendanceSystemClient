package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.facecore.FaceCompareRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceCompareResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceDetectResult;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lisao on 2016/5/18.
 */
public interface FaceCoreApi {
    String FACE_HELLO = "/api/hello";//服务器测试接口，返回服务器当前时间。
    String FACEPOINTSDETECT = "/api/facepointsdetect";//根据参数faceImage，获取图像中的人脸轮廓和特征点。
    String FACEANGLESDETECT = "/api/faceanglesdetect";//根据参数faceImage，获取图像中的人脸角度。
    String FACEDATECT = "/api/facedetect";//根据参数faceImage，获取图像中的人脸位置和特征。
    String FACECOMPARE = "/api/facecompare";//根据参数facefeature1，facefeature2获取两个人脸的相似度。
    String FACEDETECTANDCOMPARE = "/api/facedetectandcompare";//根据参数faceimage1,faceimage2获取两个人脸的相似度。
    String FACEDETECTCOUNT = "/api/facedetectcount";//根据参数faceImage，获取图像中的人脸数量。
    String URLFACEDETECT = "/api/urlfacedetect";//根据参数Url，获取图像中的人脸位置和特征。
    String URLFACEDETECTANDCOMPARE = "/api/urlfacedetectandcompare";//根据参数url1,url2获取两个人脸的相似度。
    String FACEDETECTAGEANDSEX = "/api/facedetectageandsex";//根据参数faceimage，获取图像中的人脸、眼睛位置和特征、年龄性别。

    @GET(FACE_HELLO)
    Observable<String> faceHello();

    /**
     * 获取人脸的特征值
     *
     * @param request
     * @return
     */
    @POST(FACEDATECT)
    Observable<FaceDetectResult> faceDatect(@Body FaceCompareRequest request);

    /**
     * 比较两个人脸区别
     *
     * @param request
     * @return
     */
    @POST(FACECOMPARE)
    Observable<FaceCompareResult> faceCompare(@Body FaceCompareRequest request);


}
