package com.lisao.attendancesystemclient.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.facecore.FaceAllResult;
import com.lisao.attendancesystemclient.entity.facecore.SimilarResult;

import java.util.List;

/**
 * Created by lisao on 2016/5/31.
 */
public class FaceAdapter<T> extends BaseRecyclerviewAdapter {
    public FaceAdapter(Context context, List<T> data) {
        super(context, data);
    }

    public FaceAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(View v, int viewType) {
        return new FaceHolder(v);
    }

    @Override
    protected View createItemView(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return mInflater.inflate(R.layout.item_face_view, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        T entity = (T) mDatas.get(position);
        if (entity instanceof FaceAllResult.Face) {
            ((FaceHolder) holder).setData((FaceAllResult.Face) entity);
        } else {
            ((FaceHolder) holder).setData((SimilarResult) entity);
        }
    }
}
