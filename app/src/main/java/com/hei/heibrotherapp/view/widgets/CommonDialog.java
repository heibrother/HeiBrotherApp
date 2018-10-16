package com.hei.heibrotherapp.view.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.hei.heibrotherapp.R;

/**
 * @ClassName: CommonDialog
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/15 17:56
 */

public class CommonDialog extends Dialog {

    public TextView mTvTitle;


    private CommonDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
    }

    private CommonDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_common);
    }

    public class Builder{

        public Context mContext;

        private String mTitle;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String title){
            this.mTitle = title;
            return this;
        }


        public CommonDialog create(Builder builder) {
            CommonDialog dialog = new CommonDialog(builder.mContext);
            if(!TextUtils.isEmpty(builder.mTitle)){
                dialog.mTvTitle.setText(builder.mTitle);
            }
            return dialog;
        }
    }
}
