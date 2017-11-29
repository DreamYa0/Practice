package designpatterns.template;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description 抽象模版类
 * @date 2017/11/29 下午9:32
 */
public abstract class AbstractClass {

    protected abstract void doSomething();

    protected abstract void doAnything();

    public void templateMethod() {
        doAnything();
        doSomething();
    }
}
