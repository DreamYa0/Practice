package Thinking_in_Java.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/21.
 *         P375
 */
public class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
