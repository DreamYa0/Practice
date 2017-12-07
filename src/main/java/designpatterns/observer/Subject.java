package designpatterns.observer;

/**
 * @author dreamyao
 * @description
 * @date 2017/12/6 下午8:21
 * @since 1.0.0
 */
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
