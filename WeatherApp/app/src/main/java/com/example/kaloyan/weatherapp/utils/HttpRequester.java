package com.example.kaloyan.weatherapp.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kaloyan on 05.04.17.
 */

public class HttpRequester {
    private final OkHttpClient httpClient;

    public HttpRequester() {
        this(new OkHttpClient());
    }


    public HttpRequester(OkHttpClient okHttpClient) {
        this.httpClient = new OkHttpClient();
    }

    public String getJson(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Response response = this.httpClient.newCall(request)
                .execute();

        //TODO: Add error handling 400 and so on

        return response.body().string();
    }
}
