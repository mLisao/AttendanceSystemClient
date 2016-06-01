package com.lisao.attendancesystemclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lisao.attendancesystemclient.adapter.base.BaseRecyclerviewAdapter;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.view.item.MyAttendItem;

import java.util.List;

/**
 * Created by lisao on 2016/5/30.
 */
public class MyAttendAdapter extends BaseRecyclerviewAdapter<MyAttend> {

    public MyAttendAdapter(Context context, List<MyAttend> data) {
        super(context, data);
    }

    public MyAttendAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(View v, int viewType) {
        return new MyAttendHolder(v);
    }

    @Override
    protected View createItemView(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return new MyAttendItem(mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyAttendHolder) holder).setData(mDatas.get(position));
    }

    class MyAttendHolder extends RecyclerView.ViewHolder {

        private MyAttendItem view;

        public MyAttendHolder(View itemView) {
            super(itemView);
            this.view = (MyAttendItem) itemView;
        }

        public void setData(MyAttend entity) {
            view.setData(entity);
        }
    }
}
