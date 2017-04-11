package com.example.kaloyan.weatherapp.views.weekly;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaloyan.weatherapp.R;
import com.example.kaloyan.weatherapp.models.Weather;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeeklyView extends Fragment implements WeeklyContracts.View {


    private WeeklyContracts.Presenter presenter;
    private TextView tvLabel;

    public WeeklyView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weekly, container, false);

        tvLabel = (TextView) rootView.findViewById(R.id.tv_weekly_label);

        this.presenter.start();
        return rootView;
    }

    @Override
    public void setPresenter(WeeklyContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setWeatherData(Weather weather) {
        String info = weather.daily.summary;
        this.tvLabel.setText(info);
    }
}
