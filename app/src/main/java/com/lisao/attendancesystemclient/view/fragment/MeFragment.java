package com.lisao.attendancesystemclient.view.fragment;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisao.attendancesystemclient.BuildConfig;
import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.activity.LoginActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.SettingView;

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

    @ViewBind(R.id.setting_my_room)
    private SettingView setting_my_room;

    @ViewBind(R.id.setting_my_attend)
    private SettingView setting_my_attend;

    @ViewBind(R.id.setting_suggest)
    private SettingView setting_suggest;

    @ViewBind(R.id.setting_version)
    private SettingView setting_version;

    @Override
    protected void initValue() {
        String version = BuildConfig.VERSION_NAME;
        setting_version.setTips(version);
    }

    @Override
    protected void setListener() {
        user_avatar.setOnClickListener(this);
        setting_my_room.setOnClickListener(this);
        setting_my_attend.setOnClickListener(this);
        setting_suggest.setOnClickListener(this);
        setting_version.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.user_avatar:
                //跳转到登陆界面
                intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_my_room:
                Snackbar.make(v, setting_my_room.getSettingName(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.setting_my_attend:
                Snackbar.make(v, setting_my_attend.getSettingName(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.setting_suggest:
                Snackbar.make(v, setting_suggest.getSettingName(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.setting_version:
                Snackbar.make(v, setting_version.getSettingName(), Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
