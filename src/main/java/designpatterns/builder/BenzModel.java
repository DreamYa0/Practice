package designpatterns.builder;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:25
 */
public class BenzModel extends CarModel {
    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public void alarm() {
        System.out.println("alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("engineBoom");
    }
}
