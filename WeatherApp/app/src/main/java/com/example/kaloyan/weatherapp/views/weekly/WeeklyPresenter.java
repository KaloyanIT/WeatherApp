package com.example.kaloyan.weatherapp.views.weekly;

import com.example.kaloyan.weatherapp.data.WeatherData;
import com.example.kaloyan.weatherapp.models.Weather;
import com.example.kaloyan.weatherapp.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kaloyan on 11.04.17.
 */

public class WeeklyPresenter implements WeeklyContracts.Presenter {
    private final WeeklyContracts.View view;
    private WeatherData data;

    public WeeklyPresenter(WeeklyContracts.View view) {
        this.view = view;
        this.data = new WeatherData(Constants.BASE_URL);

        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        this.data.getAllInfoWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Weather, String>() {

                    @Override
                    public String apply(Weather weather) throws Exception {
                        getView().setWeatherData(weather);
                        return weather.daily.summary;
                    }
                })
                .subscribe();
    }

    @Override
    public WeeklyContracts.View getView() {
        return this.view;
    }
}
