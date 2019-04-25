package com.example.user.weather;

import com.example.user.weather.Model.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/data/2.5/weather?q=Томск&APPID=28ebe9c07ad45cfa52cefbdac244c5fd&lang=ru&units=metric")
    Call<WeatherResponse> weather();
}
