package designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamyao on 2017/3/6.
 */
public class WeatherData implements Subject {

    /**
     * 所有观察者集合
     */
    private List observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    /**
     * 注册观察者
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 注销观察者
     *
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0) {
            observers.remove(index);
        }
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 当气象站得到更新观察值时，通知观察者
     */
    private void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}
