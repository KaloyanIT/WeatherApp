package com.example.kaloyan.weatherapp.models;

/**
 * Created by kaloyan on 12.04.17.
 */

public class ForecastDataModel {
    public long time;
    public String summary;
    public String icon;
    public long sunriseTime;
    public long sunsetTime;
    public float moonPhase;
    public float precipIntensity;
    public float precipIntensityMax;
    public long precipIntensityMaxTime;
    public float precipProbability;
    public String precipType;
    public float temperatureMin;
    public long temperatureMinTime;
    public float temperatureMax;
    public long temperatureMaxTime;
    public float apparentTemperatureMin;
    public long apparentTemperatureMinTime;
    public float apparentTemperatureMax;
    public long apparentTemperatureMaxTime;
    public float dewPoint;
    public float humidity;
    public float windSpeed;
    public long windBearing;
    public float visibility;
    public float cloudCover;
    public float pressure;
    public float ozone;

    public String getSummary() {
        return this.summary;
    }
}
