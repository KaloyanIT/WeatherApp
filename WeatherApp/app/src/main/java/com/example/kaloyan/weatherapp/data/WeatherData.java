package com.example.kaloyan.weatherapp.data;

import com.example.kaloyan.weatherapp.models.Currently;
import com.example.kaloyan.weatherapp.models.Daily;
import com.example.kaloyan.weatherapp.models.Hourly;
import com.example.kaloyan.weatherapp.utils.HttpRequester;
import com.example.kaloyan.weatherapp.utils.JsonParser;
import com.example.kaloyan.weatherapp.models.Weather;

import java.util.Currency;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/**
 * Created by kaloyan on 05.04.17.
 */

public class WeatherData {

    private final HttpRequester httpRequester;
    private final JsonParser jsonParser;
    private final String url;

    public WeatherData(String url) {
        this(url, new HttpRequester(), new JsonParser());
    }

    public WeatherData(String url, HttpRequester httpRequester, JsonParser jsonParser) {
        this.url = url;
        this.httpRequester = httpRequester;
        this.jsonParser = jsonParser;
    }


    public Observable<Weather> getAllInfoWeather() {
        return Observable.create(new ObservableOnSubscribe<Weather>() {
            @Override
            public void subscribe(ObservableEmitter<Weather> e) throws Exception {
                try {
                    String json = httpRequester.getJson(url);
                    Weather weathers = jsonParser.fromJson(json, Weather.class);
                    e.onNext(weathers);

                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        });
    }

    public Observable<Daily> getForecastForWeek() {
        return Observable.create(new ObservableOnSubscribe<Daily>() {
            @Override
            public void subscribe(ObservableEmitter<Daily> e) throws Exception {
                try {
                    String json = httpRequester.getJson(url);
                    Weather weather = jsonParser.fromJson(json, Weather.class);
                    e.onNext(weather.daily);
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        });
    }

    public Observable<Hourly> getHourlyForecast() {
        return Observable.create(new ObservableOnSubscribe<Hourly>() {
            @Override
            public void subscribe(ObservableEmitter<Hourly> e) throws Exception {
                try {
                    String json = httpRequester.getJson(url);
                    Weather weather = jsonParser.fromJson(json, Weather.class);
                    e.onNext(weather.hourly);
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        });
    }

    public Observable<Currently> getCurrentForecast() {
        return Observable.create(new ObservableOnSubscribe<Currently>() {
            @Override
            public void subscribe(ObservableEmitter<Currently> e) throws Exception {
                try {
                    String json = httpRequester.getJson(url);
                    Weather weather = jsonParser.fromJson(json, Weather.class);
                    e.onNext(weather.currently);
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        });
    }
}
