package com.example.kaloyan.weatherapp.views.home;


/**
 * Created by kaloyan on 11.04.17.
 */

public class HomePresenter implements HomeContracts.Presenter {
    private final HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;

        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public HomeContracts.View getView() {
        return this.view;
    }
}
