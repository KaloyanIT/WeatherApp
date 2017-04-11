package com.example.kaloyan.weatherapp.views.weekly;

import com.example.kaloyan.weatherapp.models.Weather;

/**
 * Created by kaloyan on 11.04.17.
 */

public interface WeeklyContracts {
    interface View {
        void setPresenter(WeeklyContracts.Presenter presenter);

        void setWeatherData(Weather weather);
    }

    interface Presenter {
        void start();

        WeeklyContracts.View getView();
    }
}
