package TestNG.Thinking_in_Java.generics;

/**
 * Created by DreamYao on 2016/11/6.
 */
public class FactoryConstraint {
}
interface FactoryI<T>{
    T create();
}
class Foo2<T>{
    private T x;

    private <F extends FactoryI<T>> Foo2(F factory) {
        x=factory.create();
    }
}
