package com.example.user.weather;

public class ApiUtils {
    private static final String baseUrl = "http://api.openweathermap.org/";
    public static Api getApi(){
        return RetrofitClient.getRetrofit(baseUrl).create(Api.class);
    }
}
