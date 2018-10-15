package com.hei.heibrotherapp.presenter.login;

import com.hei.heibrotherapp.base.mvp.BasePresenter;
import com.hei.heibrotherapp.base.mvp.IBaseView;

/**
 * @ClassName: LoginContract
 * @Description: java类作用描述
 * @Author: dongchang.Tang(01381733)
 * @Date: 2018/10/15 17:02
 */

public interface LoginContract {

    abstract class ILoginPresenter extends BasePresenter<LoginContract.ILoginView>{
        public abstract void login(String userName, String pw);
    }

    interface ILoginView extends IBaseView{
        void loginSuccess();
        void loginFail();
    }

}
