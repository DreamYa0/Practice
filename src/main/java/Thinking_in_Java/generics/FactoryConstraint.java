package Thinking_in_Java.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/6.
 *         P382 工厂对象
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}

interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}