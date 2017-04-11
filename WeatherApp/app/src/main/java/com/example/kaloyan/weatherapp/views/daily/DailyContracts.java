package com.example.kaloyan.weatherapp.views.daily;

import com.example.kaloyan.weatherapp.models.Weather;

/**
 * Created by kaloyan on 11.04.17.
 */

public interface DailyContracts {
    interface View {
        void setPresenter(DailyContracts.Presenter presenter);

        void setWeatherData(Weather weather);
    }

    interface Presenter {
        void start();

        DailyContracts.View getView();
    }
}
