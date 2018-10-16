package com.hei.heibrotherapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hei.heibrotherapp.R;
import com.hei.heibrotherapp.base.http.BaseObservable;
import com.hei.heibrotherapp.base.http.HttpManager;
import com.hei.heibrotherapp.base.mvp.BaseMvpActivity;
import com.hei.heibrotherapp.base.mvp.BasePresenter;
import com.hei.heibrotherapp.http.api.IWeatherService;
import com.hei.heibrotherapp.http.result.WeatherResultBean;

public class MainActivity extends BaseMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Nullable
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    private void test(){
        HttpManager.getInstance().createApiService(IWeatherService.class)
                .getWeather("深圳")
                .subscribe(new BaseObservable<WeatherResultBean>() {
            @Override
            protected void onSuccess(WeatherResultBean tBaseResult) {

            }

            @Override
            protected void onFail(Throwable e) {

            }
        });
    }
}
