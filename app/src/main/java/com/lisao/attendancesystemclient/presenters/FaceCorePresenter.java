package com.lisao.attendancesystemclient.presenters;

import android.graphics.Bitmap;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.FaceCoreApi;
import com.lisao.attendancesystemclient.entity.facecore.FaceCompareRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceDetectRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceDetectResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarRequest;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.view.fragment.MeFragment;
import com.lisao.lisaolibrary.logger.Logger;

import okhttp3.RequestBody;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lisao on 2016/5/18.
 */
public class FaceCorePresenter extends BasePresenter<FaceView> {
    private FaceCoreApi coreApi;

    public FaceCorePresenter(FaceView view) {
        super(view);
        coreApi = ApiUtil.createApi(FaceCoreApi.class);
    }

    public void testFaceHello() {
        onNetWork(coreApi.faceHello())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    /**
     * 获取人脸的特征值
     *
     * @param base64Bitmap
     */
    public void getFaceDatect(final String base64Bitmap) {
        FaceDetectRequest request = new FaceDetectRequest();
        request.setFaceImage(base64Bitmap);
//        coreApi.faceDatect(request)
//                .subscribeOn(Schedulers.io())
//                .flatMap(new Func1<FaceDetectResult, Observable<FaceResult>>() {
//                    @Override
//                    public Observable<FaceResult> call(FaceDetectResult faceDetectResult) {
//                        String base64feature = faceDetectResult.getFacemodels().get(0).getBase64feature();
//                        FaceRequest faceRequest = new FaceRequest();
//                        faceRequest.setNick("许蒙");
//                        faceRequest.setBase64faceimage(base64Bitmap);
//                        faceRequest.setBase64feature(base64feature);
//                        faceRequest.setFaceid(System.currentTimeMillis() + "face_core");
//                        return coreApi.updateFace(faceRequest);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<FaceResult>() {
//                    @Override
//                    public void call(FaceResult faceResult) {
//                        Logger.d("FaceDetectRequest" + JSON.toJSONString(faceResult));
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.d("FaceDetectRequest" + throwable.getMessage());
//                    }
//                });
        onNetWork(coreApi.faceDatect(request))
                .subscribe(new Action1<FaceDetectResult>() {
                    @Override
                    public void call(FaceDetectResult faceDetectResult) {
                        Logger.d("FaceDetectRequest" + JSON.toJSONString(faceDetectResult));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.d("FaceDetectRequest" + throwable.getMessage());
                    }
                });

    }

    public void faceCompare(String base64Bitmap) {

    }

    public void addFace(final String faceId, final String nickName, final String base64Bitmap) {
        FaceDetectRequest request = new FaceDetectRequest();
        request.setFaceImage(base64Bitmap);
        coreApi.faceDatect(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<FaceDetectResult>() {
                    @Override
                    public void call(FaceDetectResult faceDetectResult) {
                        String base64feature = faceDetectResult.getFacemodels()[0].getBase64feature();
                        updateFace(faceId, nickName, base64Bitmap, base64feature);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    public void updateFace(String faceId, String nickName, final String base64Bitmap, String base64feature) {
        FaceRequest faceRequest = new FaceRequest();
        StringBuilder idBulider = new StringBuilder();
        for (int i = 0; i < 20 - faceId.length(); i++) {
            idBulider.append("0");
        }
        idBulider.append(faceId);
        faceRequest.setNick(nickName);
        faceRequest.setBase64faceimage(base64Bitmap);
        faceRequest.setBase64feature(base64feature);
        faceRequest.setFaceid(idBulider.toString());
        onNetWork(coreApi.updateFace(faceRequest))
                .subscribe(new Action1<FaceResult>() {
                    @Override
                    public void call(FaceResult faceResult) {
                        Logger.d("FaceDetectRequest" + JSON.toJSONString(faceResult));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.d("FaceDetectRequest" + throwable.getMessage());
                    }
                });
    }

    /**
     * 获取最相似的人脸
     *
     * @param base64Bitmap
     */
    public void findSimilarFace(String base64Bitmap) {
        FaceDetectRequest faceDetectRequest = new FaceDetectRequest();
        faceDetectRequest.setFaceImage(base64Bitmap);
        coreApi.faceDatect(faceDetectRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<FaceDetectResult>() {
                    @Override
                    public void call(FaceDetectResult faceDetectResult) {
                        if (faceDetectResult.getFacemodels() != null && faceDetectResult.getFacemodels().length > 0) {
                            String base64feature = faceDetectResult.getFacemodels()[0].getBase64feature();
                            Logger.d("faceDetectResult.getFacemodels() " + faceDetectResult.getFacemodels());
                            FaceSimilarRequest faceSimilarRequest = new FaceSimilarRequest();
                            faceSimilarRequest.setBase64feature(base64feature);
                            faceSimilarRequest.setMaxresult(10);
                            faceSimilarRequest.setThreshold(0.6f);
                            findSimilarFace(faceSimilarRequest);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("findSimilarFace" + throwable.getMessage());
                    }
                });
    }

    public void findSimilarFace(FaceSimilarRequest faceSimilarRequest) {
        onNetWork(coreApi.getSimilar(faceSimilarRequest))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e("findSimilarFace" + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("findSimilarFace" + throwable.getMessage());
                    }
                });
    }

    public void getAll() {
        onNetWork(coreApi.faceAll())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e("getAll " + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("getAll " + throwable.getMessage());
                    }
                });
    }
}
