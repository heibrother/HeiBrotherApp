package com.hei.heibrotherapp.http.api;


import com.hei.heibrotherapp.http.result.WeatherResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName: IWeatherService
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/16 16:10
 */

public interface IWeatherService {

    @GET("weather_mini")
    Observable<WeatherResultBean> getWeather(@Query("city") String city);
}
