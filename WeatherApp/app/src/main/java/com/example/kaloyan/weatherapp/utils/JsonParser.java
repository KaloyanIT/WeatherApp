package com.example.kaloyan.weatherapp.utils;

import com.google.gson.Gson;

/**
 * Created by kaloyan on 05.04.17.
 */

public class JsonParser {
    private final Gson gson;

    public JsonParser() {
        this(new Gson());
    }

    public JsonParser(Gson gson) {
        this.gson = gson;
    }

    public <T> T fromJson(String json, Class<T> klass) {
        return gson.fromJson(json, klass);
    }
}
