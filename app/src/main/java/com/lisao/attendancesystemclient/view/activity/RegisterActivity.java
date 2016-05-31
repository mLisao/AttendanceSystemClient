package com.lisao.attendancesystemclient.view.activity;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.Student;
import com.lisao.attendancesystemclient.presenters.AccountPresenter;
import com.lisao.attendancesystemclient.presenters.vu.AccountView;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.IOSButton;

/**
 * Created by lisao on 2016/5/23.
 */
@ViewBind(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, AccountView {

    @ViewBind(R.id.toolbar)
    private Toolbar toolbar;

    @ViewBind(R.id.ed_register_number)
    private EditText ed_register_number;

    @ViewBind(R.id.ed_register_password)
    private EditText ed_register_password;

    @ViewBind(R.id.ed_register_repassword)
    private EditText ed_register_repassword;

    @ViewBind(R.id.ed_register_name)
    private EditText ed_register_name;

    @ViewBind(R.id.sp_register_college)
    private Spinner sp_register_college;

    @ViewBind(R.id.sp_register_marjor)
    private Spinner sp_register_marjor;

    @ViewBind(R.id.sp_register_grade)
    private Spinner sp_register_grade;

    @ViewBind(R.id.btn_submit)
    private IOSButton btn_reset;

    @ViewBind(R.id.btn_submit)
    private IOSButton btn_submit;

    private MarjorAdapter mMarjorAdapter;
    private AccountPresenter presenter;

    private String number;
    private String password;
    private String rePassword;
    private String name;
    private String college;
    private String marjor;
    private String grade;

    @Override
    protected void initValue() {
        toolbar.setTitle("注册");
        setSupportActionBar(toolbar);
        presenter = new AccountPresenter(this);
        Snackbar.make(toolbar, "教师不开放注册！！", Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    protected void setListener() {
        sp_register_college.setOnItemSelectedListener(this);
        btn_reset.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] marjors = getResources().getStringArray(R.array.marjor);
        mMarjorAdapter = new MarjorAdapter(this, android.R.layout.simple_spinner_item, marjors[position].split(","));
        mMarjorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_register_marjor.setAdapter(mMarjorAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reset:
                resetInput();
                break;
            case R.id.btn_submit:
                register();
                break;
        }
    }

    /**
     * 重置输入
     */
    private void resetInput() {
    }

    /**
     * 开始注册
     */
    private void register() {
        number = ed_register_number.getText().toString().trim();
        password = ed_register_password.getText().toString().trim();
        rePassword = ed_register_repassword.getText().toString().trim();
        name = ed_register_name.getText().toString().trim();
        college = sp_register_college.getSelectedItem().toString();
        marjor = sp_register_marjor.getSelectedItem().toString();
        grade = sp_register_grade.getSelectedItem().toString();
        if (TextUtils.isEmpty(number)) {
            ed_register_number.setError("学号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ed_register_repassword.setError("密码不能为空");
            return;
        }
        if (TextUtils.isEmpty(rePassword)) {
            ed_register_repassword.setError("确认密码不能为空");
            return;
        }
        if (TextUtils.isEmpty(name)) {
            ed_register_number.setError("姓名不能为空");
            return;
        }
        if (!password.equals(rePassword)) {
            ed_register_repassword.setError("两次输入密码不一致");
            return;
        }
        Student student = new Student();
        student.setNumber(Long.parseLong(number));
        student.setName(name);
        student.setPassword(password);
        student.setCollege(college);
        student.setMajor(marjor);
        student.setGrade(grade);
        presenter.register(student);
    }


    @Override
    public void showSuccess(String msg) {
        showSnackBar(toolbar, msg);
    }

    @Override
    public void showFail(String msg) {
        showSnackBar(toolbar, msg);
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }


    class MarjorAdapter extends ArrayAdapter<CharSequence> {

        public MarjorAdapter(Context context, int resource) {
            super(context, resource);
        }

        public MarjorAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public MarjorAdapter(Context context, int resource, CharSequence[] objects) {
            super(context, resource, objects);
        }
    }
}
