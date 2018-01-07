package designpatterns.wrapper;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:36
 * @since 1.0.0
 */
public abstract class BaseDecorator extends AbstractReadWord{

    protected AbstractReadWord readWord;

    public BaseDecorator(){}

    public BaseDecorator(AbstractReadWord readWord) {
        this.readWord = readWord;
    }

}
