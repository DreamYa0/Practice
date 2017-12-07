package designpatterns.observer;

/**
 * @author dreamyao
 * @description
 * @date 2017/12/6 下午10:18
 * @since 1.0.0
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay display = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80f,65f,30.4f);
    }
}
