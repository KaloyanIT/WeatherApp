package com.example.kaloyan.weatherapp.views;

/**
 * Created by kaloyan on 10.04.17.
 */

public interface MainContracts {
    public interface View {
        void setPresenter(MainContracts.Presenter presenter);
    }

    public interface Presenter {
        void start();

        MainContracts.View getView();
    }
}
