package com.WeatherApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapService {

    private static final String API_KEY = "2f61d4b600974f67a95235409243001";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    public String getCurrentWeatherByCity(String city) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "?q=" + city + "&key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "{\"error\":\"Failed to fetch weather data\"}";
        }
    }
}
