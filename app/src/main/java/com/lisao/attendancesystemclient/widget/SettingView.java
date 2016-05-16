package com.lisao.attendancesystemclient.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.utils.DensityUtil;

/**
 * Created by lisao on 2016/3/31.
 */
public class SettingView extends RelativeLayout {
    private TextView setting_name;
    private TextView setting_tips;
    private RelativeLayout setting_custom_view_group;
    private View view;
    private SwitchCompat switchCompat;

    private String name = "";
    private String tips = "";


    public SettingView(Context context) {
        this(context, null);
    }

    public SettingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = inflate(context, R.layout.item_setting_view, this);
        setting_name = (TextView) view.findViewById(R.id.setting_name);
        setting_tips = (TextView) view.findViewById(R.id.setting_tips);
        setting_custom_view_group = (RelativeLayout) view.findViewById(R.id.setting_custom_view_group);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SettingView);
        name = array.getString(R.styleable.SettingView_setting_name);
        tips = array.getString(R.styleable.SettingView_setting_tips);
        array.recycle();
        if (!TextUtils.isEmpty(name))
            setting_name.setText(name);
        if (!TextUtils.isEmpty(tips))
            setting_tips.setText(tips);

    }

    public void setTips(String tips) {
        setting_tips.setText(tips);
    }

    public void setSetting_name(String name) {
        setting_name.setText(name);
    }

    public String getSettingName() {
        return name;
    }

    public void setCustomView(View view) {
        setting_custom_view_group.removeAllViews();
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.rightMargin = DensityUtil.dip2px(6);
        layoutParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
        setting_custom_view_group.addView(view, layoutParams);
    }

}
