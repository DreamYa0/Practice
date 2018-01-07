package designpatterns.wrapper;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:02
 * @since 1.0.0
 */
public abstract class AbstractDecorator extends AbstractBird{

    protected AbstractBird bird;

    public AbstractDecorator(){

    }

    public AbstractDecorator(AbstractBird bird) {
        this.bird = bird;
    }
}
