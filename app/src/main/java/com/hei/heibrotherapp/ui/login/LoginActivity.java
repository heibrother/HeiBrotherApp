package com.hei.heibrotherapp.ui.login;

import android.content.Intent;
import android.widget.Button;

import com.hei.heibrotherapp.R;
import com.hei.heibrotherapp.base.mvp.BaseMvpActivity;
import com.hei.heibrotherapp.presenter.login.LoginContract;
import com.hei.heibrotherapp.presenter.login.LoginPresenter;
import com.hei.heibrotherapp.ui.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ClassName: LoginActivity
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/15 16:58
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.ILoginView {

    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    public void gotoLogin() {
        mPresenter.login("111", "222");
    }

    @Override
    public void loginSuccess() {
        showToast("登录成功");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFail() {
        showToast("登录失败");
    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

}
