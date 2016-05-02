package com.lisao.attendancesystemclient.view.activity;

import android.view.View;
import android.widget.Button;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/1/8.
 */
@ViewBind(R.layout.activity_main)
public class HomeActivity extends BaseActivity {
    @ViewBind(R.id.button)
    private Button button;

    @Override
    protected void initValue() {
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
