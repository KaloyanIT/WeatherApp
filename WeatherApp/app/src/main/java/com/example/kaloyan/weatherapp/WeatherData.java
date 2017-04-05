package com.example.kaloyan.weatherapp;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by kaloyan on 05.04.17.
 */

public class WeatherData {

    private final HttpRequester httpRequester;
    private final Gson jsonParser;
    private final String url;

    public WeatherData(String url) {
        this(url, new HttpRequester(), new Gson());
    }

    public WeatherData(String url, HttpRequester httpRequester, Gson jsonParser) {
        this.url = url;
        this.httpRequester = httpRequester;
        this.jsonParser = jsonParser;
    }


    public Observable<Weather[]> getAllInfoWeather() {
        return Observable.create(new ObservableOnSubscribe<Weather[]>() {
            @Override
            public void subscribe(ObservableEmitter<Weather[]> e) throws Exception {
                try {
                    String json = httpRequester.getJson(url);
                    Weather[] weathers = jsonParser.fromJson(json, Weather[].class);
                    e.onNext(weathers);
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        });
    }
}
