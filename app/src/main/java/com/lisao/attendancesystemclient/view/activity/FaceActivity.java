package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.BitmapUtil;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;

/**
 * Created by lisao on 2016/5/30.
 */
@ViewBind(R.layout.activity_face)
public class FaceActivity extends BaseActivity implements View.OnClickListener, FaceView {
    @ViewBind(R.id.btn_face_getall)
    private IOSButton btn_face_getall;

    @ViewBind(R.id.btn_face_add)
    private IOSButton btn_face_add;

    @ViewBind(R.id.btn_face)
    private IOSButton btn_face;


    private static final int CAMERA_SCAN = 1;
    private static final int CAMERA_ADD = 2;

    private FaceCorePresenter faceCorePresenter;

    @Override
    protected void initValue() {
        faceCorePresenter = new FaceCorePresenter(this);
    }

    @Override
    protected void setListener() {
        btn_face.setOnClickListener(this);
        btn_face_getall.setOnClickListener(this);
        btn_face_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_face:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_SCAN);
                break;
            case R.id.btn_face_getall:
                faceCorePresenter.getAll();
                break;
            case R.id.btn_face_add:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_ADD);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_SCAN && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            String s = BitmapUtil.bitmaptoString(bitmap);
            faceCorePresenter.findSimilarFace(s);
        } else if (requestCode == CAMERA_ADD && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            String s = BitmapUtil.bitmaptoString(bitmap);
            faceCorePresenter.addFace(System.currentTimeMillis() + "", "张三", s);
        }
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }
}