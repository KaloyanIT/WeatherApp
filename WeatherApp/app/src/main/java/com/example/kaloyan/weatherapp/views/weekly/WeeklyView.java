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
    private List<ForecastDataModel> dataModelList;



    public WeeklyView() {
        // Required empty public constructor
    }

    public static List<DayOfWeekItem> getData() {
        List<DayOfWeekItem> data = new ArrayList<>();


        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            DayOfWeekItem navItem = new DayOfWeekItem();
            navItem.setTitle(titles[i]);
            data.add(navItem);
        }
        return data;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weekly, container, false);
        this.presenter.start();
        rv_weekForecast = (RecyclerView) rootView.findViewById(R.id.rw_week_forecast);
        adapter = new WeekForecastAdapter(getContext(), dataModelList);





        dialog = ProgressDialog.show(getContext(), "Wait", "");

        rv_weekForecast.setAdapter(adapter);
        rv_weekForecast.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }

    @Override
    public void setPresenter(WeeklyContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setWeatherData(Daily daily) {
        String info = daily.summary;
        dataModelList = daily.data;
        //this.tvLabel.setText(info);
    }

    @Override
    public ProgressDialog getDialog() {
        return this.dialog;
    }
}
