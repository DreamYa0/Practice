package designpatterns.factory;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:35
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("白人会说话！");
    }
}
