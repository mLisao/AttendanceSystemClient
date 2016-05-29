package com.lisao.attendancesystemclient.presenters;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.lisao.attendancesystemclient.api.AccountApi;
import com.lisao.attendancesystemclient.api.ApiUtil;
import com.lisao.attendancesystemclient.presenters.vu.AccountView;
import com.lisao.lisaolibrary.logger.Logger;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lisao on 2016/5/15.
 */
public class AccountPresenter extends BasePresenter<AccountView> {


    private AccountApi accountApi;

    public AccountPresenter(AccountView view) {
        super(view);
        accountApi = ApiUtil.createApi(AccountApi.class);
    }

    public void register(long number, String name, String password, boolean isTeacher) {
        Observable<String> observable = null;
        if (isTeacher) {
            observable = accountApi.teacherRegister(name, password, number);
        } else {
            observable = accountApi.studentRegister(name, password, number);
        }
        onNetWork(observable)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        String msg = JSON.parseObject(s).getString("msg");
                        if (TextUtils.isEmpty(msg)) {
                            getView().showSuccess("注册成功");
                        } else {
                            getView().showFail(msg);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showFail(throwable.getMessage());
                    }
                });
    }

    public void login(long number, String password, boolean isTeacher) {
        Observable<String> observable = null;
        if (isTeacher) {
            observable = accountApi.teacherLogin(number, password);
        } else {
            observable = accountApi.studentLogin(number, password);
        }
        onNetWork(observable)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        String msg = JSON.parseObject(s).getString("msg");
                        if (TextUtils.isEmpty(msg)) {
                            getView().showSuccess("登录成功");
                        } else {
                            getView().showFail(msg);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showFail(throwable.getMessage());
                    }
                });
    }

}
