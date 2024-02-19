package com.WeatherApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse {
    public Location location;
    public Current current;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        public String name;
        public String region;
        public String country;
        public String localtime;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
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
        public double vis_km;
        public double vis_miles;
        public double uv;
        public double gust_mph;
        public double gust_kph;
    }

    public static class Condition {
        public String text;
        public String icon;
        public int code;
    }
}
