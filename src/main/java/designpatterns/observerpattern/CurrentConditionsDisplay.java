package designpatterns.observerpattern;

/**
 * Created by dreamyao on 2017/3/6.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temperature;

    private float humidity;

    private Subject weatherData;

    /**
     * 注册此观察者
     * @param weatherData
     */
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature +
        "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        display();
    }
}
