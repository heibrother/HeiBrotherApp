package com.hei.heibrotherapp.common.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

public class MyToastUtils {
    private static Toast sToast = null;

    public static void showToast(Context mContext, String id, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(mContext, id, duration);
        } else {
            sToast.setText(id);
        }
        sToast.show();
    }

    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_LONG);
    }


    public static void showToast(Context context, @StringRes int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    public static void showToast(Context context, @StringRes int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_LONG);
    }


}
