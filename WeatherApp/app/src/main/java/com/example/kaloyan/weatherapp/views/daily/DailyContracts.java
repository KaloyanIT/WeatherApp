package com.example.kaloyan.weatherapp.views.daily;

import com.example.kaloyan.weatherapp.models.Weather;
import com.example.kaloyan.weatherapp.views.MainContracts;

/**
 * Created by kaloyan on 11.04.17.
 */

public interface DailyContracts {
    public interface View extends MainContracts.View  {
        void setWeatherData(Weather weather);
    }

    public interface Presenter extends MainContracts.Presenter {

    }
}
