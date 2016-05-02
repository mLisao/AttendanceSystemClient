package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.lisaolibrary.logger.Logger;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by lisao on 2016/1/8.
 */
@ViewBind(R.layout.activity_main)
public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @ViewBind(R.id.button)
    private Button button;

    private static final int SCAN_QR_CODE = 0x1;


    @Override
    protected void initValue() {
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent();
                intent.setClass(this, CaptureActivity.class);
                startActivityForResult(intent, SCAN_QR_CODE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SCAN_QR_CODE) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Logger.e(result);
        }
    }
}
