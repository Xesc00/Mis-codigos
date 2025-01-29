package weatehr.main.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import weather.main.WeatherForecast;

public class WeatherForecastTest {
	public void unfinished_test() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", new Date());
		System.out.println(forecast);
	}
}