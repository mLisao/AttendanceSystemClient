package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;
import com.lisao.lisaolibrary.logger.Logger;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by lisao on 2016/5/22.
 */
@ViewBind(R.layout.acitivity_attend)
public class AttendActivity extends BaseActivity implements View.OnClickListener {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.btn_qr_code)
    private IOSButton btn_qr_code;

    private static final int SCAN_QR_CODE = 1;

    @Override
    protected void initValue() {
        setSupportActionBar(toolbar);
    }

    @Override
    protected void setListener() {
        btn_qr_code.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_qr_code:
                intent = new Intent(this, CaptureActivity.class);
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
