package com.lisao.attendancesystemclient.view.activity;

import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alibaba.fastjson.JSON;
import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.adapter.base.FaceAdapter;
import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;
import com.lisao.attendancesystemclient.entity.facecore.SimilarResult;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.BitmapUtil;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.lisaolibrary.logger.Logger;

/**
 * Created by lisao on 2016/5/31.
 */
@ViewBind(R.layout.activity_face_list)
public class FaceListActivity extends BaseActivity implements FaceView {
    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.recylerview)
    private RecyclerView recyclerView;

    public static final String EXTRA_BITMAP = "bitmap";

    public Bitmap bitmap;

    private FaceCorePresenter faceCorePresenter;

    private FaceAdapter<FaceAllResult.Face> mFaceAdapter;

    private FaceAdapter<SimilarResult> mSimilarAdapter;

    @Override
    protected void initValue() {
        bitmap = getIntent().getParcelableExtra(EXTRA_BITMAP);
        faceCorePresenter = new FaceCorePresenter(this);
        if (bitmap == null) {
            toolbar.setTitle("所有人脸");
            mFaceAdapter = new FaceAdapter(this);
            recyclerView.setAdapter(mFaceAdapter);
            getAllFace();
        } else {
            toolbar.setTitle("相似人脸");
            mSimilarAdapter = new FaceAdapter(this);
            recyclerView.setAdapter(mSimilarAdapter);
            getSimilarFace();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        setSupportToolBar(toolbar);
        showLoadingDialog("查找中，请稍后。");
    }

    /**
     * 获取相似的人脸
     */
    private void getSimilarFace() {
        String s = BitmapUtil.bitmaptoString(bitmap);
        faceCorePresenter.findSimilarFace(s);
    }

    /**
     * 获取所有的人脸信息
     */
    private void getAllFace() {
        faceCorePresenter.getAll();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }

    @Override
    public void showSimilarFace(FaceSimilarResult result) {
        mSimilarAdapter.addData(result.getSimilarpersonface());
        disMissDialog();
        Logger.json(JSON.toJSONString(result));
    }

    @Override
    public void showAllFace(FaceAllResult result) {
        mFaceAdapter.addData(result.getPersonfaces());
        disMissDialog();
        Logger.json(JSON.toJSONString(result));
    }
}
