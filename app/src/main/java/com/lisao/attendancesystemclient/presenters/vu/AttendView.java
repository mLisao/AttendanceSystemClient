package com.lisao.attendancesystemclient.presenters.vu;

import com.lisao.attendancesystemclient.entity.MyAttend;

import java.util.List;

/**
 * Created by lisao on 2016/5/28.
 */
public interface AttendView extends BaseVu {
    /**
     * @param attends
     */
    void showMyAttend(List<MyAttend> attends);
}
