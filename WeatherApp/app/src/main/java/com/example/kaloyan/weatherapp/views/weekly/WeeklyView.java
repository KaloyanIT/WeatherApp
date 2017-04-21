package com.example.kaloyan.weatherapp.views.weekly;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaloyan.weatherapp.R;
import com.example.kaloyan.weatherapp.adapters.WeekForecastAdapter;
import com.example.kaloyan.weatherapp.models.Daily;
import com.example.kaloyan.weatherapp.models.DayOfWeekItem;
import com.example.kaloyan.weatherapp.models.ForecastDataModel;
import com.example.kaloyan.weatherapp.models.NavDrawerItem;
import com.example.kaloyan.weatherapp.models.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeeklyView extends Fragment implements WeeklyContracts.View {
    private WeeklyContracts.Presenter presenter;
    private TextView tvLabel;
    private ProgressDialog dialog;
    private RecyclerView rv_weekForecast;
    private static String[] titles = {"pesho", "kesho", "sisho"};
    private WeekForecastAdapter adapter;

    public WeeklyView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weekly, container, false);
        dialog = ProgressDialog.show(getContext(), "Wait", "");
        rv_weekForecast = (RecyclerView) rootView.findViewById(R.id.rw_week_forecast);
        adapter = new WeekForecastAdapter(getContext(), null);
        rv_weekForecast.setAdapter(adapter);
        rv_weekForecast.setLayoutManager(new LinearLayoutManager(getContext()));
        this.presenter.start();

        return rootView;
    }

    @Override
    public void setPresenter(WeeklyContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setWeatherData(Daily daily) {
        adapter.addData(daily.data);
    }

    @Override
    public ProgressDialog getDialog() {
        return this.dialog;
    }
}
