package TestNG.Thinking_in_Java.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/24.
 *         P377 边界处的动作
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
