package com.example.user.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.weather.Model.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView max;
    TextView min;
    TextView speed;
    TextView desc;
    private Api api;
    WeatherResponse weatherResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        max = findViewById(R.id.max);
        min = findViewById(R.id.min);
        speed = findViewById(R.id.speed);
        desc = findViewById(R.id.desc);
        Log.e("NORM","norm");
        api = ApiUtils.getApi();
        weatherResponses = new WeatherResponse();
        loadWeather();

          /*  name.setText(weatherResponses.);
            max.setText(weatherResponses.getMain().getTemp_max().toString());
            min.setText(weatherResponses.getMain().getTemp_min().toString());
            speed.setText(weatherResponses.getWind().getSpeed());
            desc.setText(weatherResponses.ggetWeather().getDescription());*/

        Log.e("NORM","norm3");
    }
    public void loadWeather(){
        Log.e("NORM","norm1");
       api.weather().enqueue(new Callback<WeatherResponse>() {
           @Override
           public void onResponse(retrofit2.Call<WeatherResponse> call, Response<WeatherResponse> response) {
               if (response.isSuccessful()){
                   Log.e("NORM","norm2 "+response.body());
                   Toast.makeText(getApplicationContext(),"NORM "+response.code(),Toast.LENGTH_LONG).show();
                   assert response.body() != null;
                   name.setText(response.body().getName());
                   max.setText(response.body().getMain().getTemp_max().toString());
                   min.setText(response.body().getMain().getTemp_min().toString());
                   speed.setText(response.body().getWind().getSpeed());
                   desc.setText(response.body().getWeather().get(0).getDescription());
               }
               else
                   Toast.makeText(getApplicationContext(),"ERROR "+response.code(),Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(retrofit2.Call<WeatherResponse> call, Throwable t) {
               Log.e("NORM","norm2 "+t);
               Toast.makeText(getApplicationContext(),"NORM "+t,Toast.LENGTH_LONG).show();

           }
       });
    }
}
