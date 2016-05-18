package com.lisao.attendancesystemclient.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import com.lisao.attendancesystemclient.app.CustomApplication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lisao on 2016/5/18.
 */
public class ImageUtil {
    public static String ImageEncode(Uri uri) {
        Context context = CustomApplication.getInstance();
        String baseStr = "";
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] bytes = bos.toByteArray();
            byte[] encodeBytes = Base64.encode(bytes, Base64.DEFAULT);
            baseStr = new String(encodeBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseStr;
    }

    public static Bitmap ImageDecode(String base64) {
        byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return bitmap;
    }
}
