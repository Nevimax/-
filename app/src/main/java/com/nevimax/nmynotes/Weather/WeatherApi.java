package com.nevimax.nmynotes.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<Weather> getWeatherFromApi (
            @Query("q") String cityName,
            @Query("APPID") String appId,
            @Query("units") String unit);

}
