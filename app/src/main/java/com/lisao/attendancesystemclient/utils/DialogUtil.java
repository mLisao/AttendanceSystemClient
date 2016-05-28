package com.lisao.attendancesystemclient.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lisao.attendancesystemclient.R;


public class DialogUtil {

    public static void showUpdateVersion(final Context context, String title, String msg, final onListener positive, final onListener negative) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_dailog_text_view, null);
        TextView tv = (TextView) view.findViewById(R.id.version_info);
        tv.setText(msg);

        AlertDialog dialog = new AlertDialog.Builder(context, R.style.AlertDialog)
                .setTitle(title)
                .setView(view)
                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (positive != null)
                            positive.onClick(dialog, which);
                    }

                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (negative != null)
                            negative.onClick(dialog, which);
                    }
                }).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public interface onListener {
        void onClick(DialogInterface dialog, int which);
    }
}
