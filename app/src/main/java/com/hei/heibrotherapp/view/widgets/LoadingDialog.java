package com.hei.heibrotherapp.view.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.hei.heibrotherapp.R;

/**
 * @ClassName: LoadingDialog
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/15 17:56
 */

public class LoadingDialog extends Dialog {

    public TextView mTvTitle;


    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}
