package com.lisao.attendancesystemclient.view.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.lang.reflect.Field;

/**
 * Created by lisao on 2016/1/8.
 */
public abstract class BaseFragment extends Fragment {
    protected View layoutView;
    protected int ViewId;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.getClass().getAnnotation(ViewBind.class) != null) {
            ViewId = this.getClass().getAnnotation(ViewBind.class).value();
            layoutView = inflater.inflate(ViewId, container, false);
        }
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getAnnotation(ViewBind.class) != null) {
                    int id = fields[i].getAnnotation(ViewBind.class).value();
                    fields[i].set(this, findViewById(id));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        initValue();
        setListener();
        return layoutView;
    }

    protected abstract void initValue();

    protected abstract void setListener();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected <T extends View> T findViewById(int id) {
        return (T) layoutView.findViewById(id);
    }

    protected Toast mToast;

    protected void showToast(int id) {
        if (mToast == null) {
            mToast = new Toast(getContext());
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(id);
            mToast.show();
        }

    }

    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = new Toast(getContext());
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(msg);
            mToast.show();
        }
    }


    /**
     * 不带参数进行Intent跳转
     *
     * @param clz
     */
    protected void startActivity(Class clz) {
        Intent intent = new Intent();
        intent.setClass(getContext(), clz);
        startActivity(intent);
    }
}
