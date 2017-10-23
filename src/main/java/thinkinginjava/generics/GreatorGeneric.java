package thinkinginjava.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/8.
 *         P383
 */
public class GreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
