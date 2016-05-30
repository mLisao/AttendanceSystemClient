package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.facecore.FaceCompareRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceCompareResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceDetectRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceDetectResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lisao on 2016/5/18.
 */
public interface FaceCoreApi {
    String FACE_HELLO = "hello";//服务器测试接口，返回服务器当前时间。
    String FACEPOINTSDETECT = "facepointsdetect";//根据参数faceImage，获取图像中的人脸轮廓和特征点。
    String FACEANGLESDETECT = "faceanglesdetect";//根据参数faceImage，获取图像中的人脸角度。
    String FACEDATECT = "facedetect";//根据参数faceImage，获取图像中的人脸位置和特征。
    String FACECOMPARE = "facecompare";//根据参数facefeature1，facefeature2获取两个人脸的相似度。
    String FACEDETECTANDCOMPARE = "facedetectandcompare";//根据参数faceimage1,faceimage2获取两个人脸的相似度。
    String FACEDETECTCOUNT = "facedetectcount";//根据参数faceImage，获取图像中的人脸数量。
    String URLFACEDETECT = "urlfacedetect";//根据参数Url，获取图像中的人脸位置和特征。
    String URLFACEDETECTANDCOMPARE = "urlfacedetectandcompare";//根据参数url1,url2获取两个人脸的相似度。
    String FACEDETECTAGEANDSEX = "facedetectageandsex";//根据参数faceimage，获取图像中的人脸、眼睛位置和特征、年龄性别。
    String PERSONFACESIMILAR = "personface/similar";//获取人脸库中与目标人脸一定相似度的人脸
    String PERSONFACEGETALL = "personface/getall";//返回appkey存储的全部人脸
    String FACEPERSONFACE = "personface";//添加/修改一张人脸


    @GET(FACE_HELLO)
    Observable<String> faceHello();

    /**
     * 获取人脸的特征值
     *
     * @param request
     * @return
     */
    @POST(FACEDATECT)
    Observable<FaceDetectResult> faceDatect(@Query("appkey") String appke, @Body FaceDetectRequest request);

    /**
     * 比较两个人脸区别
     *
     * @param request
     * @return
     */
    @POST(FACECOMPARE)
    Observable<FaceCompareResult> faceCompare(@Query("appkey") String appke, @Body FaceCompareRequest request);

    /**
     * 获取所有的人脸信息
     *
     * @return
     */
    @GET(PERSONFACEGETALL)
    Observable<String> faceAll(@Query("appkey") String appkey);

    /**
     * 添加或修改一张人脸
     *
     * @param request
     * @return
     */
    @POST(FACEPERSONFACE)
    Observable<FaceResult> updateFace(@Query("appkey") String appke, @Body FaceRequest request);

    /**
     * 获取一定相似度的人脸
     *
     * @return
     */
    @POST(PERSONFACESIMILAR)
    Observable<String> getSimilar(@Query("appkey") String appke, @Body FaceSimilarRequest request);
}
