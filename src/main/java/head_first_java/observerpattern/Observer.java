package head_first_java.observerpattern;

/**
 * Created by dreamyao on 2017/3/6.
 */

/**
 * 所有观察者的公共接口
 */
public interface Observer {

    public void update(float temperature, float humidity, float pressure);
}
