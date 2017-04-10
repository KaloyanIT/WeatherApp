package com.example.kaloyan.weatherapp.views.daily;

import com.example.kaloyan.weatherapp.views.MainContracts;

/**
 * Created by kaloyan on 10.04.17.
 */

public class DailyPresenter implements MainContracts.Presenter {
    private final MainContracts.View view;

    public DailyPresenter(MainContracts.View view) {
        this.view = view;

        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public MainContracts.View getView() {
        return this.view;
    }
}
