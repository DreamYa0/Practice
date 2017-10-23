package thinkinginjava.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/21.
 *         P375
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T x) {
        obj = x;
    }

    public T get() {
        return obj;
    }
}
