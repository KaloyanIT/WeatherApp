package com.example.kaloyan.weatherapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaloyan.weatherapp.R;
import com.example.kaloyan.weatherapp.models.Daily;
import com.example.kaloyan.weatherapp.models.DayOfWeekItem;
import com.example.kaloyan.weatherapp.models.ForecastDataModel;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by kaloyan on 12.04.17.
 */

public class WeekForecastAdapter extends RecyclerView.Adapter<WeekForecastAdapter.MyViewHolder> {
    private List<ForecastDataModel> data = Collections.emptyList();
    private LayoutInflater inflater;
    private final Context context;

    public WeekForecastAdapter(Context context, List<ForecastDataModel> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.week_forecast_row,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ForecastDataModel current = data.get(position);
        holder.title.setText("No title");
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_forecast_title);
        }
    }

    public void addData(List<ForecastDataModel> currData) {
        this.data = currData;
    }

}
