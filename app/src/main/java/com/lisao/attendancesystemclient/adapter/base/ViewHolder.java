package com.lisao.attendancesystemclient.adapter.base;

import android.util.SparseArray;
import android.view.View;


/**
 * Created by lisao on 2015/10/29.
 * 通用ViewHolder
 */
public class ViewHolder<T> {
    public static <T extends View> T getView(View convertView, int id) {
        SparseArray<View> holder = (SparseArray<View>) convertView.getTag();
        if (holder == null) {
            holder = new SparseArray<View>();
            convertView.setTag(holder);
        }
        View childView = holder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            holder.put(id, childView);
        }
        return (T) childView;
    }
}
