package com.hei.heibrotherapp.base.mvp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hei.heibrotherapp.common.utils.ToastUtils;
import com.hei.heibrotherapp.view.widgets.LoadingDialog;

import java.nio.Buffer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ClassName: BaseActivity
 * @Description: 通用的Activity基类
 * @Author: dongchang.Tang
 * @Date: 2018/10/12 18:25
 */

public abstract class BaseActivity extends AppCompatActivity {

    private  Unbinder mUnbinder;
    private LoadingDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initBaseView();
        initView();
        initBaseData();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDialog = null;
        if (null != mUnbinder) {
            mUnbinder.unbind();
        }
    }

    protected void initBaseView() {
        mUnbinder = ButterKnife.bind(this);
    }

    protected void initBaseData(){

    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

    /**
     * 显示toast
     * @param msg
     */
    public void showToast(String msg) {
        ToastUtils.showToast(this,msg);
    }

    /**
     * 显示对话框
     */
    public void showDialog(String msg){
        if (null == mDialog) {
            mDialog = new LoadingDialog(this);
        }
        mDialog.setTitle(msg);
        mDialog.show();
    }

    public void hideDialog(){
        if (null != mDialog) {
            mDialog.dismiss();
        }
    }


}
