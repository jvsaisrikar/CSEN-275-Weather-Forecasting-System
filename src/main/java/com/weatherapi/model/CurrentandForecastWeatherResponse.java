package com.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentandForecastWeatherResponse {

public Location location;
public Current current;
public Forecast forecast;
public Alerts alerts;

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Location {
    public String name;
    public String region;
    public String country;
    public String localtime;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Current {
    public String last_updated;
    public double temp_c;
    public double temp_f;
    public int is_day;
    public Condition condition;
    public double wind_mph;
    public double wind_kph;
    public String wind_dir;
    public double pressure_mb;
    public double pressure_in;
    public double precip_mm;
    public double precip_in;
    public int humidity;
    public double feelslike_c;
    public double feelslike_f;
    public double vis_km;
    public double vis_miles;
    public double uv;
    public double gust_mph;
    public double gust_kph;
    public AirQuality air_quality;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Condition {
    public String text;
    public String icon;
    public int code;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class AirQuality {
    public double co;
    public double no2;
    public double o3;
    public double so2;
    public double pm2_5;
    public double pm10;
    public int us_epa_index;
    public int gb_defra_index;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Forecast {
    public ForecastDay[] forecastday;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class ForecastDay {
    public String date;
    public long date_epoch;
    public Day day;
    public Astro astro;
    public Hour[] hour;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Day {
    public double maxtemp_c;
    public double maxtemp_f;
    public double mintemp_c;
    public double mintemp_f;
    public double avgtemp_c;
    public double avgtemp_f;
    public double maxwind_mph;
    public double maxwind_kph;
    public double totalprecip_mm;
    public double totalprecip_in;
    public double totalsnow_cm;
    public double avgvis_km;
    public double avgvis_miles;
    public int avghumidity;
    public int daily_will_it_rain;
    public int daily_chance_of_rain;
    public int daily_will_it_snow;
    public int daily_chance_of_snow;
    public Condition condition;
    public double uv;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Astro {
    public String sunrise;
    public String sunset;
    public String moonrise;
    public String moonset;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Hour {
    public String time;
    public double temp_c;
    public double temp_f;
    public int is_day;
    public Condition condition;
    public double wind_mph;
    public double wind_kph;
    public int wind_degree;
    public String wind_dir;
    public double pressure_mb;
    public double pressure_in;
    public double precip_mm;
    public double precip_in;
    public double snow_cm;
    public int humidity;
    public int cloud;
    public double feelslike_c;
    public double feelslike_f;
    public double windchill_c;
    public double windchill_f;
    public double heatindex_c;
    public double heatindex_f;
    public int will_it_rain;
    public int chance_of_rain;
    public int will_it_snow;
    public int chance_of_snow;
    public double vis_km;
    public double vis_miles;
    public double gust_mph;
    public double gust_kph;
    public double uv;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Alerts {
    public Alert[] alert;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Alert {
    public String headline;
    public String category;
    public String event;
    public String effective;
    public String expires;
    public String desc;
}
}