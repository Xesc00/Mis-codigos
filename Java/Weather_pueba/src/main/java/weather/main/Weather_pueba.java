package weather.main;

import java.io.IOException;
import weatehr.main.test.WeatherForecastTest;

public class Weather_pueba {
    public Weather_pueba() throws IOException{
        WeatherForecastTest weatherForecastTest = new WeatherForecastTest();//Instancia
        weatherForecastTest.unfinished_test();
    }

    public static void main(String[] args) throws IOException {
        new Weather_pueba();
        
        System.out.println("A");
    }
}
