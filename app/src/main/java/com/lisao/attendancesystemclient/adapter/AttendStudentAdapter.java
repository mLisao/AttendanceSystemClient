package com.lisao.attendancesystemclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lisao.attendancesystemclient.adapter.base.BaseRecyclerviewAdapter;
import com.lisao.attendancesystemclient.entity.Student;
import com.lisao.attendancesystemclient.view.item.AttendStudentItem;

import java.util.List;

/**
 * Created by lisao on 2016/6/3.
 */
public class AttendStudentAdapter extends BaseRecyclerviewAdapter<Student> {

    public AttendStudentAdapter(Context context, List<Student> data) {
        super(context, data);
    }

    public AttendStudentAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(View v, int viewType) {
        return new AttendStudentHolder(v);
    }

    @Override
    protected View createItemView(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return new AttendStudentItem(mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AttendStudentHolder) holder).setData(mDatas.get(position));
    }

    class AttendStudentHolder extends RecyclerView.ViewHolder {

        private AttendStudentItem view;

        public AttendStudentHolder(View itemView) {
            super(itemView);
            this.view = (AttendStudentItem) itemView;
        }

        public void setData(Student student) {
            view.setData(student);
        }
    }
}
