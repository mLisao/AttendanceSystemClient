package com.lisao.attendancesystemclient.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.FaceSimilarResult;
import com.lisao.attendancesystemclient.entity.facecore.SimilarResult;
import com.lisao.attendancesystemclient.utils.BitmapUtil;

import butterknife.ButterKnife;

/**
 * Created by lisao on 2016/5/31.
 */
public class FaceHolder extends RecyclerView.ViewHolder {
    ImageView iv_face;

    TextView tv_name;

    TextView tv_similar;

    TextView tv_create_time;

    public FaceHolder(View itemView) {
        super(itemView);
        iv_face = (ImageView) itemView.findViewById(R.id.iv_face);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_similar = (TextView) itemView.findViewById(R.id.tv_similar);
        tv_create_time = (TextView) itemView.findViewById(R.id.tv_create_time);
    }

    public void setData(FaceAllResult.Face face) {
        Bitmap bitmap = BitmapUtil.base64ToBitmap(face.getBase64faceimage());
        iv_face.setImageBitmap(bitmap);
        tv_similar.setVisibility(View.GONE);
        tv_create_time.setText("创建时间:" + face.getCreatetime());
        tv_name.setText("姓名:" + face.getNick());
    }

    public void setData(SimilarResult result) {
        Bitmap bitmap = BitmapUtil.base64ToBitmap(result.getBase64faceimage());
        iv_face.setImageBitmap(bitmap);
        tv_similar.setText("相似度:" + result.getSimilar());
        tv_create_time.setText("创建时间:" + result.getCreatetime());
        tv_name.setText("姓名:" + result.getNick());
    }
}
