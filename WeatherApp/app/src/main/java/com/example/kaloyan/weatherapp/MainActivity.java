package com.example.kaloyan.weatherapp;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.OkHttpClient;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpRequester httpRequester = new HttpRequester();
        String url = "http://192.168.0.103:3001/api/foods";
        try {
            String responseJson = httpRequester.getJson(url);
            System.out.print(responseJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
