package com.lisao.attendancesystemclient.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/1/8.
 */
@ViewBind(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    private static final int GO_HOME = 1;
    private static final int GO_LOGIN = 2;
    private static final int GO_ADMIN = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    startActivity(HomeActivity.class);
                    finish();
                    break;
                case GO_LOGIN:
                    startActivity(LoginActivity.class);
                    finish();
                    break;
                case GO_ADMIN:
                    startActivity(AttendActivity.class);
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initValue() {
        if (!PreferencesUtil.getBoolean(PreferencesUtil.IS_LOGIN, false)) {
            handler.sendEmptyMessageDelayed(GO_LOGIN, 1000);
        } else {
            if (PreferencesUtil.getBoolean(PreferencesUtil.IS_TEACHER, false)) {
                handler.sendEmptyMessageDelayed(GO_ADMIN, 1000);
            } else {
                handler.sendEmptyMessageDelayed(GO_HOME, 1000);
            }
        }
    }

    @Override
    protected void setListener() {

    }
}
