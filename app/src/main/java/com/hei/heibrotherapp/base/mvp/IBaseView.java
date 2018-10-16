package com.hei.heibrotherapp.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @ClassName: IBaseView
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/15 16:45
 */

public interface IBaseView {

    /**
     * 初始化Presenter
     * @return
     */
    @Nullable
    BasePresenter initPresenter();

    /**
     * 获取Activity引用
     * @return
     */
    @NonNull
    BaseActivity getActivity();

    void showToast(String msg);

    void showDialog(String msg);

    void showDefaultDialog();

    void hideDialog();


}
