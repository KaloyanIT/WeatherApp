package com.example.kaloyan.weatherapp.views.daily;

import com.example.kaloyan.weatherapp.data.WeatherData;
import com.example.kaloyan.weatherapp.models.Weather;
import com.example.kaloyan.weatherapp.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kaloyan on 10.04.17.
 */

public class DailyPresenter implements DailyContracts.Presenter {
    private final DailyContracts.View view;
    private WeatherData data;

    public DailyPresenter(DailyContracts.View view) {
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
                        weather = weather;
                        //TextView tv_title = (TextView) findViewById(R.id.my_textview) ;
                        //tv_title.setText(weather.daily.summary);
                        getView().getDialog().dismiss();
                        getView().setWeatherData(weather);
                        return weather.daily.summary;
                    }
                })
                .subscribe();
    }

    @Override
    public DailyContracts.View getView() {
        return this.view;
    }
}
