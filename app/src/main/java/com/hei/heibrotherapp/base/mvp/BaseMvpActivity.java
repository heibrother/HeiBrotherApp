package com.hei.heibrotherapp.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hei.heibrotherapp.R;

/**
 * @ClassName: BaseMvpActivity
 * @Description: java类作用描述
 * @Author: dongchang.Tang(01381733)
 * @Date: 2018/10/15 16:45
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = (P) initPresenter();
        if (null != mPresenter) {
            mPresenter.onAttachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.onDettachView();
        }
    }

    @NonNull
    @Override
    public final BaseActivity getActivity() {
        return this;
    }

    @Override
    public void showToast(String msg) {
        super.showToast(msg);
    }

    @Override
    public void showDialog(String msg) {
        super.showDialog(msg);
    }

    @Override
    public void showDefaultDialog() {
        super.showDialog(getString(R.string.loading));
    }

    @Override
    public void hideDialog() {
        super.hideDialog();
    }
}
