package com.lisao.attendancesystemclient.view.fragment;

import android.view.View;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.TimeTableModel;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.ScheduleTableView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment implements View.OnClickListener {

    @ViewBind(R.id.time_schedule)
    private ScheduleTableView mTimaTableView;

    private List<TimeTableModel> mList;

    @Override
    protected void initValue() {
        mList = new ArrayList<TimeTableModel>();
        addList();
        mTimaTableView.setTimeTable(mList);
    }

    private void addList() {
        mList.add(new TimeTableModel(1, 2, 1, "财务报表分析", "1"));
        mList.add(new TimeTableModel(3, 4, 1, "审计实务", "2"));
        mList.add(new TimeTableModel(6, 7, 1, "市场营销实务", "3"));
        mList.add(new TimeTableModel(6, 7, 2, "财务管理实务", "4"));
        mList.add(new TimeTableModel(8, 9, 2, "财务报表分析", "5"));
        mList.add(new TimeTableModel(1, 2, 3, "审计实务", "6"));
        mList.add(new TimeTableModel(6, 7, 3, "管理会计实务", "7"));
        mList.add(new TimeTableModel(3, 5, 4, "财务管理实务", "8"));
        mList.add(new TimeTableModel(8, 9, 4, "管理会计实务", "9"));
        mList.add(new TimeTableModel(3, 5, 5, "税务筹划", "10"));
        mList.add(new TimeTableModel(6, 8, 5, "证券投资分析", "11"));
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View v) {
    }

}
