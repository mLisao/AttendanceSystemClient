package com.lisao.attendancesystemclient.view.fragment;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.api.ScheduleApi;
import com.lisao.attendancesystemclient.entity.Schedule;
import com.lisao.attendancesystemclient.entity.TimeTableModel;
import com.lisao.attendancesystemclient.entity.parse.Parse;
import com.lisao.attendancesystemclient.presenters.SchedulePresenter;
import com.lisao.attendancesystemclient.presenters.vu.ScheduleView;
import com.lisao.attendancesystemclient.utils.DialogUtil;
import com.lisao.attendancesystemclient.view.activity.AttendActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.ScheduleTableView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment implements
        ScheduleView,
        View.OnClickListener,
        ScheduleTableView.EmptyAreaClickListener,
        ScheduleTableView.UnEmptyAreaClickListener {

    @ViewBind(R.id.time_schedule)
    private ScheduleTableView mTimaTableView;

    private List<TimeTableModel> mList;
    private List<Schedule> mSchedules;

    private SchedulePresenter schedulePresenter;

    @Override
    protected void initValue() {
        mList = new ArrayList<>();
        mSchedules = new ArrayList<>();
        schedulePresenter = new SchedulePresenter(this);
//        addList();
//        mTimaTableView.setTimeTable(mList);
        schedulePresenter.getAllSchedule();//获取所有的课表数据
    }

//    private void addList() {
//        mList.add(new TimeTableModel(1, 2, 1, "软件项目管理", "计算机综合楼203"));
//        mList.add(new TimeTableModel(3, 4, 1, "计算机网络", "计算机综合楼104"));
//        mList.add(new TimeTableModel(5, 6, 1, "创业指导", "计算机综合楼102"));
//        mList.add(new TimeTableModel(7, 8, 1, "音乐鉴赏", "一号教学楼1302"));
//        mList.add(new TimeTableModel(9, 10, 1, "网络安全技术", "计算机综合楼103"));
//
//        mList.add(new TimeTableModel(1, 2, 2, "计算机组成原理", "计算机综合楼104"));
//        mList.add(new TimeTableModel(9, 10, 2, "多媒体技术", "计算机综合楼103"));
//
//        mList.add(new TimeTableModel(1, 2, 3, "软件项目管理", "计算机综合楼203"));
//        mList.add(new TimeTableModel(3, 4, 3, "Java程序设计", "计算机综合楼107"));
//        mList.add(new TimeTableModel(5, 6, 3, "计算机网络", "计算机综合楼104"));
//        mList.add(new TimeTableModel(7, 8, 3, "多媒体技术", "计算机综合楼103"));
//        mList.add(new TimeTableModel(9, 10, 3, "网络安全技术", "计算机综合楼103"));
//
//        mList.add(new TimeTableModel(1, 2, 4, "计算机组成原理", "计算机综合楼104"));
//        mList.add(new TimeTableModel(3, 4, 4, "操作系统", "计算机综合楼203"));
//        mList.add(new TimeTableModel(5, 6, 4, "软件项目管理", "计算机综合楼103"));
//        mList.add(new TimeTableModel(9, 10, 4, "多媒体技术", "计算机综合楼103"));
//
//        mList.add(new TimeTableModel(1, 2, 5, "Java程序设计", "计算机综合楼107"));
//        mList.add(new TimeTableModel(5, 6, 5, "创业指导", "计算机综合楼104"));
//    }

    @Override
    protected void setListener() {
        mTimaTableView.setEmptyAreaClickListener(this);
        mTimaTableView.setUnEmptyAreaClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void OnEmptyAreaClick(int week, int start, int num) {
//        DialogUtil.showUpdateVersion(mContext, "签到提示", "签到成功", null, null);
    }

    @Override
    public void onUnEmptyAreaClick(TimeTableModel model) {
        Intent intent = new Intent();
        intent.setClass(mContext, AttendActivity.class);
        intent.putExtra(AttendActivity.EXTRA_ENTIY, model.getSchedule());
        mContext.startActivity(intent);
    }

    /**
     * 显示所有的列表
     *
     * @param schedules
     */
    @Override
    public void showSchedule(List<Schedule> schedules) {
        mSchedules = schedules;
        mList = Parse.parse(schedules);
        mTimaTableView.setTimeTable(mList);
    }

    @Override
    public void showStatus(boolean isSuccess, String msg) {

    }
}
