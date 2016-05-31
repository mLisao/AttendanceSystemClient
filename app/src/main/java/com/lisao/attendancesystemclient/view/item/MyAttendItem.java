package com.lisao.attendancesystemclient.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;
import com.lisao.attendancesystemclient.adapter.base.Bind;

import butterknife.ButterKnife;

/**
 * Created by lisao on 2016/5/30.
 */
public class MyAttendItem extends View {
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.content)
    TextView content;

    public MyAttendItem(Context context) {
        super(context);
        init(context);
    }

    public MyAttendItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyAttendItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化视图
     *
     * @param context
     */
    private void init(Context context) {
        View view = inflate(context, R.layout.item_my_attend_view, null);
        ButterKnife.bind(this, view);
    }
}
