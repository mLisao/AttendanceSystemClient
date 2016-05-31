package com.lisao.attendancesystemclient.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lisao on 2016/5/30.
 */
public class MyAttendAdapter extends BaseRecyclerviewAdapter {

    public MyAttendAdapter(Context context, List data) {
        super(context, data);
    }

    public MyAttendAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(View v, int viewType) {
        return null;
    }

    @Override
    protected View createItemView(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    class MyAttendHolder extends RecyclerView.ViewHolder {

        public MyAttendHolder(View itemView) {
            super(itemView);
        }
    }
}
