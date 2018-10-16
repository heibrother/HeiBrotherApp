package com.hei.heibrotherapp.base.http;

import com.hei.heibrotherapp.http.api.IWeatherService;
import com.hei.heibrotherapp.http.result.WeatherResultBean;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: HttpManager
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/16 16:00
 */

public class HttpManager {

    private static volatile HttpManager mInstance;

    private Retrofit mRetrofit;

    private final String BASE_URL = "http://wthrcdn.etouch.cn/";

    private HttpManager() {
        mRetrofit = createRetrofit();
    }

    public static HttpManager getInstance(){
        if (null == mInstance) {
            synchronized (HttpManager.class) {
                mInstance = new HttpManager();
            }
        }
        return mInstance;
    }

    private Retrofit createRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());//RxJava 适配器
        Retrofit retrofit = builder.build();
        return retrofit;
    }

    public <T> Observable<T> compose(Observable<T> observable) {
        return observable.compose(new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return  upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        });
    }

    public <T> T createApiService(Class<T> service){
        return mRetrofit.create(service);
    }


    private void test(){
        IWeatherService apiService = createApiService(IWeatherService.class);
        apiService.getWeather("北京").subscribe(new BaseObservable<WeatherResultBean>() {
            @Override
            void onSuccess(WeatherResultBean tBaseResult) {

            }

            @Override
            void onFail(Throwable e) {

            }
        });
    }
}
