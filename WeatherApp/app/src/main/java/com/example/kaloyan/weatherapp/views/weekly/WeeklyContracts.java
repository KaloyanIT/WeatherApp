package com.example.kaloyan.weatherapp.views.weekly;

import android.app.ProgressDialog;

import com.example.kaloyan.weatherapp.models.Daily;
import com.example.kaloyan.weatherapp.models.Weather;

/**
 * Created by kaloyan on 11.04.17.
 */

public interface WeeklyContracts {
    interface View {
        void setPresenter(WeeklyContracts.Presenter presenter);

        void setWeatherData(Daily daily);

        ProgressDialog getDialog();


    }

    interface Presenter {
        void start();

        WeeklyContracts.View getView();
    }
}
