package com.example.kaloyan.weatherapp.views;

import android.view.View;

/**
 * Created by kaloyan on 23.04.17.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
