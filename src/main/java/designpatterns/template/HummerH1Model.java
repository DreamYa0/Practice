package designpatterns.template;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午9:28
 */
public class HummerH1Model extends HummerModel {

    @Override
    public void start() {
        System.out.println("");
    }

    @Override
    public void stop() {
        System.out.println("");
    }

    @Override
    public void alarm() {
        System.out.println("");
    }

    @Override
    public void engineBoom() {
        System.out.println("");
    }

    @Override
    public void run() {
        start();
        engineBoom();
        alarm();
        stop();
    }
}
