package com.WeatherApi;

public class WeatherApiApplication {

	public static void main(String[] args) {
		CurrentWeatherService service = new CurrentWeatherService();
		CurrentWeatherResponse currentWeatherResponse = service.getCurrentWeather("76.132.58.66");
		if (currentWeatherResponse != null) {
			System.out.println("Current temperature in " + currentWeatherResponse.location.name + ": " + currentWeatherResponse.current.temp_c + "°C");
		} else {
			System.out.println("Failed to fetch weather data.");
		}
	}
}
