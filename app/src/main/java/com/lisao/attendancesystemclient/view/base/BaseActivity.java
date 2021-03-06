package com.lisao.attendancesystemclient.view.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.activity.HomeActivity;
import com.lisao.lisaolibrary.logger.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lisao on 2016/1/8.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    protected ProgressDialog dialog;

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
                if (View.class.isAssignableFrom(fields[i].getType()) && fields[i].getAnnotation(ViewBind.class) != null) {
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

    public void setSupportToolBar(Toolbar toolBar) {
        setSupportToolBar(toolBar, true);
    }

    public void setSupportToolBar(Toolbar toolBar, boolean showHomeUp) {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeUp);
    }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (this instanceof HomeActivity) {
                return false;
            } else {
                finish();
            }
        }
        return true;
    }


    protected void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackBar(View view, int msgId) {
        Snackbar.make(view, msgId, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * @param clz 不参数跳转
     */
    protected void startActivity(Class clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }

    protected void showLoadingDialog(String msg) {
        if (dialog == null) {
            dialog = ProgressDialog.show(this, "", msg, false, true);
        } else {
            dialog.setMessage(msg);
        }
        dialog.show();
    }

    protected void disMissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog.cancel();
        }
    }
}