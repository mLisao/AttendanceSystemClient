package com.lisao.attendancesystemclient.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.BitmapUtil;
import com.lisao.attendancesystemclient.utils.DialogUtil;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;
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

    @ViewBind(R.id.btn_view_attent)
    private IOSButton btn_view_attent;

    @ViewBind(R.id.btn_quit_login)
    private IOSButton btn_quit_login;

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;


    private static final int CAMERA_SCAN = 1;
    private static final int CAMERA_ADD = 2;

    private FaceCorePresenter faceCorePresenter;

    @Override
    protected void initValue() {
        faceCorePresenter = new FaceCorePresenter(this);
        toolbar.setTitle("人脸管理");
        setSupportToolBar(toolbar);
    }

    @Override
    protected void setListener() {
        btn_face.setOnClickListener(this);
        btn_face_getall.setOnClickListener(this);
        btn_face_add.setOnClickListener(this);
        btn_quit_login.setOnClickListener(this);
        btn_view_attent.setOnClickListener(this);
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
                startActivity(FaceListActivity.class);
                break;
            case R.id.btn_face_add:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_ADD);
                break;
            case R.id.btn_quit_login:
                DialogUtil.showDailog(mContext, "确认退出?", "退出当前账号并退出应用，确认这么做吗？", new DialogUtil.onListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PreferencesUtil.putBoolean(PreferencesUtil.IS_LOGIN, false);
                        startActivity(LoginActivity.class);
                        finish();
                    }
                }, new DialogUtil.onListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                break;
            case R.id.btn_view_attent:
                //查看已经签到的学生
                startActivity(AttendStudentActivity.class);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_SCAN && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            Intent intent = new Intent(this, FaceListActivity.class);
            intent.putExtra(FaceListActivity.EXTRA_BITMAP, bitmap);
            startActivity(intent);
        } else if (requestCode == CAMERA_ADD && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            Intent intent = new Intent(this, AddFaceActivity.class);
            intent.putExtra(AddFaceActivity.EXTRA_IMAGE, bitmap);
            startActivity(intent);
        }
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }

    @Override
    public void showSimilarFace(FaceSimilarResult result) {

    }

    @Override
    public void showAllFace(FaceAllResult result) {

    }
}
