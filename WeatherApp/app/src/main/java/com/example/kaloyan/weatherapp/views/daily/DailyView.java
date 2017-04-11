package com.example.kaloyan.weatherapp.views.daily;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaloyan.weatherapp.R;
import com.example.kaloyan.weatherapp.models.Daily;
import com.example.kaloyan.weatherapp.models.Weather;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyView extends Fragment implements DailyContracts.View {
    private DailyContracts.Presenter presenter;
    private TextView tvDailyLabel;
    private ProgressDialog dialog;


    public DailyView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily, container, false);

        tvDailyLabel = (TextView) rootView.findViewById(R.id.tv_daily_label);
        dialog = ProgressDialog.show(getContext(), "Wait", "");

        this.presenter.start();

        return rootView;
    }

    public ProgressDialog getDialog() {
        return this.dialog;
    }

    public void setWeatherData(Weather weather) {
        tvDailyLabel.setText(weather.timezone);
    }

    @Override
    public void setPresenter(DailyContracts.Presenter presenter) {
        this.presenter = presenter;
    }
}
