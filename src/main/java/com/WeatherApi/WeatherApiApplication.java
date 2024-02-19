package com.WeatherApi;

public class WeatherApiApplication {

	public static void main(String[] args) {
		CurrentandForecastWeatherService service = new CurrentandForecastWeatherService();
		CurrentandForecastWeatherResponse currentandForecastWeatherResponse = service.getCurrentandForecastWeather("94568");
		// overloading allowed with number of days, default value is set to 1
		// getCurrentandForecastWeather("94568", 3);
		if (currentandForecastWeatherResponse != null) {
			System.out.println("Current temperature in " + currentandForecastWeatherResponse.location.name + ": " + currentandForecastWeatherResponse.current.temp_c + "°C");
		} else {
			System.out.println("Failed to fetch weather data.");
		}
	}
}

