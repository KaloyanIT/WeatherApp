package com.example.kaloyan.weatherapp.models;

/**
 * Created by kaloyan on 05.04.17.
 */

public class Weather {
    public float latitude;
    public float longitude;
    public String timezone;
    public int offset;
    public Currently currently;
    public Hourly hourly;
    public Daily daily;
    //public Map<String, Currently[]> currently;
}
