package designpatterns.wrapper;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:03
 * @since 1.0.0
 */
public class SparrowDecorator extends AbstractDecorator{

    public final int DISTANCE = 50;

    public SparrowDecorator(AbstractBird bird) {
        super(bird);
    }

    @Override
    public int fly() {
        int distance = 0;
        distance = bird.fly() + eleFly();
        return distance;
    }

    private int eleFly(){
        return DISTANCE;
    }
}
