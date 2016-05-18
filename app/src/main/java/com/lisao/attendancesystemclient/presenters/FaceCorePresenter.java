package com.lisao.attendancesystemclient.presenters;

import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.api.FaceCoreApi;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.lisaolibrary.logger.Logger;

import rx.functions.Action1;

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

}
