package designpatterns.abstractfactory;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:34
 */
public abstract class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("黄人会说话！");
    }
}
