package com.lisao.attendancesystemclient.view.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisao.attendancesystemclient.BuildConfig;
import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.utils.DialogUtil;
import com.lisao.attendancesystemclient.utils.PreferencesUtil;
import com.lisao.attendancesystemclient.view.activity.FaceActivity;
import com.lisao.attendancesystemclient.view.activity.LoginActivity;
import com.lisao.attendancesystemclient.view.activity.MyAttendActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;
import com.lisao.attendancesystemclient.widget.SettingView;
import com.lisao.lisaolibrary.logger.Logger;

import java.util.prefs.Preferences;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_me)
public class MeFragment extends BaseFragment implements View.OnClickListener {
    @ViewBind(R.id.tv_name)
    private TextView tv_name;

    @ViewBind(R.id.user_bg)
    private ImageView user_bg;

    @ViewBind(R.id.user_avatar)
    private ImageView user_avatar;

    @ViewBind(R.id.setting_my_attend)
    private SettingView setting_my_attend;

    @ViewBind(R.id.setting_suggest)
    private SettingView setting_suggest;

    @ViewBind(R.id.setting_version)
    private SettingView setting_version;

    @ViewBind(R.id.btn_quit_login)
    private IOSButton btn_quit_login;

    @Override
    protected void initValue() {
        String version = BuildConfig.VERSION_NAME;
        setting_version.setTips(version);
    }

    @Override
    protected void setListener() {
        user_avatar.setOnClickListener(this);
        setting_my_attend.setOnClickListener(this);
        setting_suggest.setOnClickListener(this);
        setting_version.setOnClickListener(this);
        btn_quit_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.user_avatar:
                //跳转到登陆界面
//                intent = new Intent(mContext, LoginActivity.class);
//                startActivity(intent);
                break;
            case R.id.setting_my_attend:
                startActivity(MyAttendActivity.class);
                break;
            case R.id.setting_suggest:
                Snackbar.make(v, setting_suggest.getSettingName(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.setting_version:
                startActivity(FaceActivity.class);
                break;
            case R.id.btn_quit_login:
                DialogUtil.showDailog(mContext, "确认退出?", "退出当前账号并退出应用，确认这么做吗？", new DialogUtil.onListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PreferencesUtil.putBoolean(PreferencesUtil.IS_LOGIN, false);
                        startActivity(LoginActivity.class);
                        getActivity().finish();
                    }
                }, new DialogUtil.onListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        tv_name.setText(PreferencesUtil.getString(PreferencesUtil.NAME, ""));
    }


}
