package com.lisao.attendancesystemclient.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.view.base.BaseActivity;
import com.lisao.attendancesystemclient.view.base.ViewBind;
import com.lisao.attendancesystemclient.view.fragment.MeFragment;
import com.lisao.attendancesystemclient.view.fragment.ScheduleFragment;
import com.lisao.attendancesystemclient.view.fragment.SchoolFragment;

/**
 * Created by lisao on 2016/1/8.
 */
@ViewBind(R.layout.activity_main)
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @ViewBind(R.id.tab1)
    private LinearLayout tab1;
    @ViewBind(R.id.iv_tab1)
    private ImageView iv_tab1;
    @ViewBind(R.id.tv_tab1)
    private TextView tv_tab1;

    @ViewBind(R.id.tab2)
    private LinearLayout tab2;
    @ViewBind(R.id.iv_tab2)
    private ImageView iv_tab2;
    @ViewBind(R.id.tv_tab2)
    private TextView tv_tab2;

    @ViewBind(R.id.tab3)
    private LinearLayout tab3;
    @ViewBind(R.id.iv_tab3)
    private ImageView iv_tab3;
    @ViewBind(R.id.tv_tab3)
    private TextView tv_tab3;

    private static final int CONTAINER = R.id.container;

    private FragmentManager mFragmentManager;

    private Fragment[] fragments;

    private static final int SCAN_QR_CODE = 0x1;

    @Override
    protected void initValue() {
        mFragmentManager = this.getSupportFragmentManager();
        fragments = new Fragment[3];
        select(0);
    }

    private void select(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);//隐藏所有的fragment
        resetColor();
        switch (position) {
            case 0:
                if (fragments[position] == null) {
                    fragments[0] = new ScheduleFragment();
                    transaction.add(CONTAINER, fragments[0]);
                }
                iv_tab1.setImageResource(R.mipmap.ic_class_select);
                tv_tab1.setTextColor(getResources().getColor(R.color.tab_text_select));
                break;
            case 1:
                if (fragments[position] == null) {
                    fragments[1] = new SchoolFragment();
                    transaction.add(CONTAINER, fragments[1]);
                }
                iv_tab2.setImageResource(R.mipmap.ic_school_select);
                tv_tab2.setTextColor(getResources().getColor(R.color.tab_text_select));
                break;
            case 2:
                if (fragments[position] == null) {
                    fragments[2] = new MeFragment();
                    transaction.add(CONTAINER, fragments[2]);
                }
                iv_tab3.setImageResource(R.mipmap.ic_me_select);
                tv_tab3.setTextColor(getResources().getColor(R.color.tab_text_select));
                break;
        }
        transaction.show(fragments[position]);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 重新设置颜色
     */
    private void resetColor() {
        iv_tab1.setImageResource(R.mipmap.ic_class_unselect);
        tv_tab1.setTextColor(getResources().getColor(R.color.tab_text_unselect));
        iv_tab2.setImageResource(R.mipmap.ic_school_unselect);
        tv_tab2.setTextColor(getResources().getColor(R.color.tab_text_unselect));
        iv_tab3.setImageResource(R.mipmap.ic_me_unselect);
        tv_tab3.setTextColor(getResources().getColor(R.color.tab_text_unselect));
    }

    /**
     * 隐藏所有显示的fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        for (int i = 0; i < fragments.length; i++) {
            if (fragments[i] != null)
                transaction.hide(fragments[i]);
        }
    }


    @Override
    protected void setListener() {
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
//        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                select(0);
                break;
            case R.id.tab2:
                select(1);
                break;
            case R.id.tab3:
                select(2);
                break;
        }
    }
//        Intent intent = null;
//        switch (v.getId()) {
////            case R.id.button:
////                intent = new Intent();
////                intent.setClass(this, CaptureActivity.class);
////                startActivityForResult(intent, SCAN_QR_CODE);
////                break;
//
//        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == SCAN_QR_CODE) {
//            Bundle bundle = data.getExtras();
//            String result = bundle.getString("result");
//            Logger.e(result);
//        }
    }
}
