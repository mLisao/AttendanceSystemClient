package com.lisao.attendancesystemclient.presenters.vu;

import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;

/**
 * Created by lisao on 2016/5/18.
 */
public interface FaceView extends BaseVu {
    void showSimilarFace(FaceSimilarResult result);

    void showAllFace(FaceAllResult result);
}
