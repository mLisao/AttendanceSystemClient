package com.lisao.attendancesystemclient.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.entity.TimeTableModel;
import com.lisao.attendancesystemclient.presenters.FaceCorePresenter;
import com.lisao.attendancesystemclient.presenters.vu.FaceView;
import com.lisao.attendancesystemclient.utils.ImageUtil;
import com.lisao.attendancesystemclient.utils.RecylerViewManagerFactory;
import com.lisao.attendancesystemclient.view.activity.LoginActivity;
import com.lisao.attendancesystemclient.view.base.BaseFragment;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.widget.TimeTableView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisao on 2016/5/11.
 */
@ViewBind(R.layout.fragment_schedule)
public class ScheduleFragment extends BaseFragment implements View.OnClickListener {

    @ViewBind(R.id.time_schedule)
    private TimeTableView mTimaTableView;

    private List<TimeTableModel> mList;

    @Override
    protected void initValue() {
        mList = new ArrayList<TimeTableModel>();
        addList();
        mTimaTableView.setTimeTable(mList);
    }

    private void addList() {
        mList.add(new TimeTableModel(0, 1, 2, 1, "8:20", "10:10", "财务报表分析",
                "王老师", "1", "2-13"));
        mList.add(new TimeTableModel(0, 3, 4, 1, "8:20", "10:10", "审计实务",
                "李老师", "2", "2-13"));
        mList.add(new TimeTableModel(0, 6, 7, 1, "8:20", "10:10", "市场营销实务",
                "王", "3", "2-13"));
        mList.add(new TimeTableModel(0, 6, 7, 2, "8:20", "10:10", "财务管理实务",
                "老师1", "4", "2-13"));
        mList.add(new TimeTableModel(0, 8, 9, 2, "8:20", "10:10", "财务报表分析",
                "老师2", "5", "2-13"));
        mList.add(new TimeTableModel(0, 1, 2, 3, "8:20", "10:10", "审计实务",
                "老师3", "6", "2-13"));
        mList.add(new TimeTableModel(0, 6, 7, 3, "8:20", "10:10", "管理会计实务",
                "老师4", "7", "2-13"));
        mList.add(new TimeTableModel(0, 3, 5, 4, "8:20", "10:10", "财务管理实务",
                "老师4", "8", "2-13"));
        mList.add(new TimeTableModel(0, 8, 9, 4, "8:20", "10:10", "管理会计实务",
                "老师5", "9", "2-13"));
        mList.add(new TimeTableModel(0, 3, 5, 5, "8:20", "10:10", "税务筹划",
                "老师6", "10", "2-13"));
        mList.add(new TimeTableModel(0, 6, 8, 5, "8:20", "10:10", "证券投资分析",
                "老师7", "11", "2-13"));
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View v) {
    }

}
