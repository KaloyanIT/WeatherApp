package com.example.kaloyan.weatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kaloyan.weatherapp.data.WeatherData;
import com.example.kaloyan.weatherapp.models.Weather;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.listView);
        final ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);

//        HttpRequester httpRequester = new HttpRequester();
          String url = "http://192.168.0.103:3001/api/foods";
//        try {
//            String responseJson = httpRequester.getJson(url);
//            System.out.print(responseJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        WeatherData data = new WeatherData(url);
        data.getAllInfoWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Weather[], Object>() {

                    @Override
                    public Object apply(Weather[] weathers) throws Exception {
                        ArrayList<String> weathersString = new ArrayList<String>();
                        for (int i = 0; i < weathers.length; i++) {
                            weathersString.add(weathers[i].name);
                        }
                        adapter.addAll(weathersString);
                        return weathersString;
                    }
                })
                .subscribe();




    }
}
