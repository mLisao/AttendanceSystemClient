package com.lisao.attendancesystemclient.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisao on 2016/4/18.
 */
public abstract class BaseRecyclerviewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    private OnItemClickListener clickListener;
    private OnItemLongClickListener longClickListener;

    /**
     * @param context
     * @param data
     */
    public BaseRecyclerviewAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.mDatas = data;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * @param context
     */
    public BaseRecyclerviewAdapter(Context context) {
        this(context, new ArrayList<T>());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = createItemView(mInflater, parent, viewType);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        return createHolder(v, viewType);
    }

    /**
     * 创建View holder
     *
     * @param v
     * @param viewType
     * @return
     */
    protected abstract RecyclerView.ViewHolder createHolder(View v, int viewType);

    /***
     * 创建视图
     *
     * @param mInflater
     * @param parent
     * @param viewType
     * @return
     */
    protected abstract View createItemView(LayoutInflater mInflater, ViewGroup parent, int viewType);


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 向后一个集合数据
     *
     * @param data
     */
    public void addData(List<T> data) {
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 移除数据
     */
    public void removeData() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (clickListener != null)
            clickListener.onItemClick(v, this, (Integer) v.getTag());
    }

    @Override
    public boolean onLongClick(View v) {
        if (longClickListener != null)
            longClickListener.onItemLongClick(v, this, (Integer) v.getTag());
        return true;
    }

    /**
     * 设置item点击事件
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    /**
     * 设置item长按事件
     *
     * @param listener
     */
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, BaseRecyclerviewAdapter adapter, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, BaseRecyclerviewAdapter adapter, int position);
    }
}
