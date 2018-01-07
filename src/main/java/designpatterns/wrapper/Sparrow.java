package designpatterns.wrapper;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:00
 * @since 1.0.0
 */
public class Sparrow extends AbstractBird{

    public final int DISTANCE = 100;

    @Override
    public int fly() {
        return DISTANCE;
    }
}
