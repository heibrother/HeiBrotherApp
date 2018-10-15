package com.hei.heibrotherapp.presenter.login;

import android.os.Handler;
import android.os.Looper;


/**
 * @ClassName: LoginPresenter
 * @Description: java类作用描述
 * @Author: dongchang.Tang(01381733)
 * @Date: 2018/10/15 17:01
 */

public class LoginPresenter extends LoginContract.ILoginPresenter {


    @Override
    public void login(String userName, String pw) {
        mView.showDefaultDialog();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.hideDialog();
                mView.loginSuccess();
            }
        },2000);

    }

    @Override
    protected void clear() {

    }
}
