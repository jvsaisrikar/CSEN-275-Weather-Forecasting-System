package com.weatherapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.model.CurrentandForecastWeatherResponse;
import org.springframework.stereotype.Service;


@Service
public class CurrentandForecastWeatherService {
    private static final String API_KEY = "2f61d4b600974f67a95235409243001";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/forecast.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Method with default numberOfDays
    public CurrentandForecastWeatherResponse getCurrentandForecastWeather(String inputCurrentWeather) {
        return getCurrentandForecastWeather(inputCurrentWeather, 1); // Default value set to 1
    }

    // Overloaded method with numberOfDays parameter
    public CurrentandForecastWeatherResponse getCurrentandForecastWeather(String inputCurrentWeather, int numberOfDays) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "?q=" + inputCurrentWeather + "&days=" + numberOfDays + "&key=" + API_KEY + "&aqi=yes" + "&alerts=yes";
        System.out.println("Calling forecast API: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Deserialize JSON response into CurrentandForecastWeatherResponse object
            return objectMapper.readValue(response.body(), CurrentandForecastWeatherResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}