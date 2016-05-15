package com.lisao.attendancesystemclient.view.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.utils.RecylerViewManagerFactory;
import com.lisao.attendancesystemclient.view.activity.LoginActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment implements View.OnClickListener {
    @ViewBind(R.id.recyclerView)
    private RecyclerView recyclerView;

    @ViewBind(R.id.button1)
    private Button button;

    private GridLayoutManager layoutManager;

    @Override
    protected void initValue() {
        layoutManager = RecylerViewManagerFactory.creatVerticalGridManger(mContext, 3);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
