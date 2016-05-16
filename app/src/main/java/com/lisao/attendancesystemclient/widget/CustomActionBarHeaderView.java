package com.lisao.attendancesystemclient.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.lisaolibrary.logger.Logger;


public class CustomActionBarHeaderView extends LinearLayout {

    private TextView mHeaderTvSubTitle;
    private LinearLayout leftBtnBack;
    private ImageView actionbar_icon;


    public CustomActionBarHeaderView(Context context) {
        this(context, null);
    }

    public CustomActionBarHeaderView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public CustomActionBarHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.cutom_header_view, this);
        mHeaderTvSubTitle = (TextView) findViewById(R.id.id_actionbar_text);
        leftBtnBack = (LinearLayout) findViewById(R.id.id_actionbar_back);
        actionbar_icon = (ImageView) findViewById(R.id.id_actionbar_icon);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomActionBarHeaderView);
        boolean isOnlyTitle = array.getBoolean(R.styleable.CustomActionBarHeaderView_only_title, false);
        boolean isOnlgIcon = array.getBoolean(R.styleable.CustomActionBarHeaderView_only_left_icon, false);
        String title = array.getString(R.styleable.CustomActionBarHeaderView_left_title);
        Drawable drawable = array.getDrawable(R.styleable.CustomActionBarHeaderView_left_icon);
        Logger.d("isOnlyTitle" + isOnlyTitle);
        Logger.d("isOnlgIcon" + isOnlgIcon);
        if (isOnlgIcon && isOnlyTitle) {
            throw new IllegalArgumentException("only_title and only_left_icon two attr is not simultaneously  set");
        }
        if (isOnlgIcon) {
            mHeaderTvSubTitle.setVisibility(GONE);
            actionbar_icon.setImageDrawable(drawable);
        }
        if (isOnlyTitle) {
            leftBtnBack.setVisibility(GONE);
            mHeaderTvSubTitle.setText(title);
        }
        array.recycle();
    }

    public interface onLeftImageButtonClickListener {
        void click();
    }

    public onLeftImageButtonClickListener lefeBtnClick;

    public void setLeftAIcon(@DrawableRes int res) {
        actionbar_icon.setImageResource(res);
        leftBtnBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (lefeBtnClick != null) {
                    lefeBtnClick.click();
                }
            }
        });
    }

    public void setTitle(String title) {
        mHeaderTvSubTitle.setText(title);
    }

    public void setLefeBtnClick(
            onLeftImageButtonClickListener onLefBtnClickListener) {
        this.lefeBtnClick = onLefBtnClickListener;
    }
}
