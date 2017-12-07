package designpatterns.observer;

/**
 * @author dreamyao
 * @description
 * @date 2017/12/6 下午8:22
 * @since 1.0.0
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
