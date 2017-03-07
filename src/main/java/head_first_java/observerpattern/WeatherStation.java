package head_first_java.observerpattern;

/**
 * Created by dreamyao on 2017/3/6.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
