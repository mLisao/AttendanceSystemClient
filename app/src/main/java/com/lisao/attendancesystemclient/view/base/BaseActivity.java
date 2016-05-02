package com.lisao.attendancesystemclient.view.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lisao.attendancesystemclient.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lisao on 2016/1/8.
 */
public abstract class BaseActivity extends Activity {
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenName();
        try {
            if (this.getClass().getAnnotation(ViewBind.class) != null) {
                int viewId = this.getClass().getAnnotation(ViewBind.class).value();
                Method m = this.getClass().getMethod("setContentView", int.class);
                m.invoke(this, viewId);
            }
            Field[] fields = this.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].getAnnotation(ViewBind.class) != null) {
                    int viewId = fields[i].getAnnotation(ViewBind.class).value();
                    if (viewId == 0) {
                        String fieldName = fields[i].getName();
                        viewId = R.id.class.getField(fieldName).getInt(R.id.class);
                    }
                    fields[i].set(this, findViewById(viewId));
                }
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mContext = this;
        setListener();
        initValue();
    }

    protected abstract void initValue();

    protected abstract void setListener();

    protected String ScreenName() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected Toast mToast;

    protected void showToast(int id) {
        if (mToast == null) {
            mToast = new Toast(this);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(id);
            mToast.show();
        }
    }

    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = new Toast(this);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(msg);
            mToast.show();
        }
    }

    /**
     * @param clz 不参数跳转
     */
    protected void startActivity(Class clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }
}