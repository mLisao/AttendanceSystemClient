package com.lisao.attendancesystemclient.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.utils.RecylerViewManagerFactory;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment {
    @ViewBind(R.id.recyclerView)
    private RecyclerView recyclerView;

    private GridLayoutManager layoutManager;

    @Override
    protected void initValue() {
        layoutManager = RecylerViewManagerFactory.creatVerticalGridManger(mContext, 3);
    }

    @Override
    protected void setListener() {

    }
}
