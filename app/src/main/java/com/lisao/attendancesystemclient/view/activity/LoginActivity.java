package com.lisao.attendancesystemclient.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.presenters.AccountPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AccountView;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/5/15.
 */
@ViewBind(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener, AccountView {
    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.login)
    private Button login;

    @ViewBind(R.id.number)
    private TextInputEditText tx_number;

    @ViewBind(R.id.password)
    private TextInputEditText tx_password;

    @ViewBind(R.id.teacherCheck)
    private AppCompatCheckBox teacherCheck;

    private AccountPresenter accountPresenter;

    @Override
    protected void initValue() {
        toolbar.setTitle("登录");
        setSupportToolBar(toolbar);
        accountPresenter = new AccountPresenter(this);
    }

    @Override
    protected void setListener() {
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                accountLogin();
                break;
        }
    }

    /**
     * 用户登登录
     */
    private void accountLogin() {
        String txNumber = tx_number.getText().toString().trim();
        String password = tx_password.getText().toString().trim();

        if (TextUtils.isEmpty(txNumber)) {
            tx_number.setError("学号或工号不可以为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            tx_password.setError("密码不可以为空");
            return;
        }
        long number = Long.parseLong(txNumber);
        accountPresenter.login(number, password, teacherCheck.isChecked());
    }

    @Override
    public void showSuccess(String msg) {
        showSnackBar(toolbar, msg);
    }

    @Override
    public void showFail(String msg) {
        showSnackBar(toolbar, msg);
    }
}
