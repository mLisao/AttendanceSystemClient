package com.lisao.attendancesystemclient.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.ImageUtil;
import com.lisao.attendancesystemclient.utils.RecylerViewManagerFactory;
import com.lisao.attendancesystemclient.view.activity.LoginActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment implements View.OnClickListener, FaceView {
    @ViewBind(R.id.recyclerView)
    private RecyclerView recyclerView;

    @ViewBind(R.id.button1)
    private Button button;

    @ViewBind(R.id.button2)
    private Button button2;

    @ViewBind(R.id.image)
    private ImageView image;


    private GridLayoutManager layoutManager;
    private static final int SELECT_PHOTO = 1;
    private FaceCorePresenter faceCorePresenter;

    @Override
    protected void initValue() {
        layoutManager = RecylerViewManagerFactory.creatVerticalGridManger(mContext, 3);
        faceCorePresenter = new FaceCorePresenter(this);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                faceCorePresenter.testFaceHello();
//                intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, SELECT_PHOTO);
        }
    }

    private String s = "";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PHOTO && resultCode == Activity.RESULT_OK && data != null) {
            s = ImageUtil.ImageEncode(data.getData());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(s)) {
            Bitmap bitmap = ImageUtil.ImageDecode(s);
            image.setImageBitmap(bitmap);
        }
    }
}
