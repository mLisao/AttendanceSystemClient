package com.lisao.attendancesystemclient.view.activity;

import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;
import com.lisao.attendancesystemclient.presenters.AttendPresenter;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.AttendView;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.BitmapUtil;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;

/**
 * Created by lisao on 2016/5/31.
 */
@ViewBind(R.layout.activity_add_face)
public class AddFaceActivity extends BaseActivity implements FaceView, View.OnClickListener {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.iv_face)
    private ImageView iv_face;

    @ViewBind(R.id.tv_name)
    private TextView tv_name;

    @ViewBind(R.id.btn_done)
    private IOSButton btn_done;

    private FaceCorePresenter faceCorePresenter;

    public static final String EXTRA_IMAGE = "image";

    public Bitmap bitmap;

    @Override
    protected void initValue() {
        toolbar.setTitle("添加人脸信息");
        bitmap = getIntent().getParcelableExtra(EXTRA_IMAGE);
        iv_face.setImageBitmap(bitmap);
        setSupportToolBar(toolbar);
        faceCorePresenter = new FaceCorePresenter(this);
    }

    @Override
    protected void setListener() {
        btn_done.setOnClickListener(this);
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {
        disMissDialog();
        showSnackBar(tv_name, msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                addFace();
                break;
        }
    }

    private void addFace() {
        String name = tv_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showSnackBar(tv_name, "姓名不能为空");
            return;
        }
        String base64Image = BitmapUtil.bitmaptoString(bitmap);
        faceCorePresenter.addFace(System.currentTimeMillis() + "", name, base64Image);
        showLoadingDialog("图片解码上传中，请稍后。。。");
    }

    @Override
    public void showSimilarFace(FaceSimilarResult result) {

    }

    @Override
    public void showAllFace(FaceAllResult result) {

    }
}
