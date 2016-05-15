package com.lisao.attendancesystemclient.presenters;

import android.support.annotation.NonNull;

import com.lisao.attendancesystemclient.presenters.vu.BaseVu;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lisao on 2016/5/15.
 */
public abstract class BasePresenter<E extends BaseVu> {
    private WeakReference<E> weakReference;

    public BasePresenter(E view) {
        this.weakReference = new WeakReference<E>(view);
    }

    protected E getView() {
        return weakReference.get();//获取的view可能为null
    }

    protected <T> Observable<T> onNetWork(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
