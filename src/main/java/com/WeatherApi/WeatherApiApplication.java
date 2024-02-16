package com.WeatherApi;

public class WeatherApiApplication {

	public static void main(String[] args) {
		OpenWeatherMapService service = new OpenWeatherMapService();
		String weatherData = service.getCurrentWeatherByCity("London");
		System.out.println(weatherData);
	}
}
