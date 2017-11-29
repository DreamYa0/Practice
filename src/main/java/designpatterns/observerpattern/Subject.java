package designpatterns.observerpattern;

/**
 * Created by dreamyao on 2017/3/6.
 */

/**
 * 主题
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 注销观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     * @param
     */
    public void notifyObserver();
}
