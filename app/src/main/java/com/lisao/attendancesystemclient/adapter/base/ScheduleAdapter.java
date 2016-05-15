package com.lisao.attendancesystemclient.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lisao.attendancesystemclient.entity.Classe;

import java.util.List;

/**
 * Created by lisao on 2016/5/12.
 */
public class ScheduleAdapter extends BaseRecyclerviewAdapter<Classe> {

    public ScheduleAdapter(Context context, List<Classe> data) {
        super(context, data);
    }

    public ScheduleAdapter(Context context) {
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

}
