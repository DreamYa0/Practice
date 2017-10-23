package thinkinginjava.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/21.
 *         P375
 */
public class Manipulator3 {
    private HasF obj;

    public Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
