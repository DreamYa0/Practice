package designpatterns.observer;

/**
 * @author dreamyao
 * @description
 * @date 2017/12/6 下午8:34
 * @since 1.0.0
 */
public class CurrentConditionDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + temperature + "F degrees and" + humidity + "% humidity");
    }
}
