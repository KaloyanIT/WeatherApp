package com.example.kaloyan.weatherapp.views.daily;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaloyan.weatherapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyView extends Fragment {


    public DailyView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily, container, false);


        return rootView;
    }

}
