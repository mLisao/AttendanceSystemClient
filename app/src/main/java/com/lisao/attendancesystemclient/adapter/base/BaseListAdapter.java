package com.lisao.attendancesystemclient.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础ListAdatper,所有的Adapter继承此Adapter
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas = new ArrayList<T>();
    private boolean isFrist;
    private Field[] fields;
    private Map<Integer, Field> viewMap;

    protected LayoutInflater getLayoutInflater(Context context) {
        if (mInflater == null) {
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return mInflater;
    }

    public BaseListAdapter(Context context, List datas) {
        this.mContext = context;
        this.mDatas = datas;
        getLayoutInflater(mContext);
        isFrist = true;
        viewMap = new HashMap<Integer, Field>();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int i) {
        if (mDatas.size() > i) {
            return mDatas.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setData(List<T> data) {
        mDatas = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mDatas == null ? (mDatas = new ArrayList<T>()) : mDatas;
    }

    //往前插数据
    public void addDataFront(List<T> data) {
        if (data == null || data.isEmpty()) {
            return;
        }
        List<T> tempData = new ArrayList<T>();
        if (mDatas != null) {
            tempData.addAll(mDatas);
            mDatas.clear();
            mDatas.addAll(data);
            mDatas.addAll(tempData);
        }
        notifyDataSetChanged();
    }

    //插入数据
    public void addData(List<T> data) {
        if (mDatas != null && data != null && !data.isEmpty()) {
            mDatas.addAll(data);
        }
        notifyDataSetChanged();
    }

    //插入单条数据
    public void addItem(T obj) {
        if (mDatas != null) {
            mDatas.add(obj);
        }
        notifyDataSetChanged();
    }

    //在指定位置上插入一条数据
    public void addItem(int pos, T obj) {
        if (mDatas != null) {
            mDatas.add(pos, obj);
        }
        notifyDataSetChanged();
    }

    public void removeItem(Object obj) {
        mDatas.remove(obj);
        notifyDataSetChanged();
    }

    //移除制定位置上的数据
    public void removeItem(int pos) {
        mDatas.remove(pos);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = bindView(position, convertView, viewGroup);
        try {
            if (isFrist) {
                fields = this.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    if (fields[i].getAnnotation(Bind.class) != null) {
                        int id = fields[i].getAnnotation(Bind.class).value();
                        fields[i].set(this, ViewHolder.getView(convertView, id));
                        viewMap.put(id, fields[i]);
                    }
                }
                isFrist = false;
            } else {
                for (Map.Entry<Integer, Field> entry : viewMap.entrySet()) {
                    int viewID = entry.getKey();
                    Field field = entry.getValue();
                    field.set(this, ViewHolder.getView(convertView, viewID));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        setValue(convertView, position);
        return convertView;
    }

    protected abstract View bindView(int position, View convertView, ViewGroup viewGroup);

    protected abstract void setValue(View convertView, int position);

}
