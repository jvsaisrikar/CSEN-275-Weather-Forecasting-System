package com.WeatherApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {
    private static final String API_KEY = "2f61d4b600974f67a95235409243001";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    //Pass US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name.
    public CurrentWeatherResponse getCurrentWeather(String inputCurrentWeather) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "?q=" + inputCurrentWeather + "&key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Deserialize JSON response into WeatherResponse object
            return objectMapper.readValue(response.body(), CurrentWeatherResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
