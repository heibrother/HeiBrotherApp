package com.hei.heibrotherapp.base.mvp;

/**
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/15 16:55
 */

public abstract class BasePresenter<V extends IBaseView> {

    protected V mView;


    void onAttachView(V view) {
        this.mView = view;
    }

    /**
     * 断开view的引用
     */
    void onDettachView() {
        this.mView = null;
        clear();
    }

    /**
     * 清理其他资源
     * 如：网络请求中断
     */
    protected abstract void clear();

}
