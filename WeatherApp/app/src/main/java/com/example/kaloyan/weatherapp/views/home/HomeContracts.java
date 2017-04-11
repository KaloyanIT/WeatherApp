package com.example.kaloyan.weatherapp.views.home;

import com.example.kaloyan.weatherapp.models.Weather;

/**
 * Created by kaloyan on 11.04.17.
 */

public interface HomeContracts {
    interface View {
        void setPresenter(HomeContracts.Presenter presenter);
    }

    interface Presenter {
        void start();

        HomeContracts.View getView();
    }
}
