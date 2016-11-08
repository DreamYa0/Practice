package TestNG.Thinking_in_Java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/8.
 *         P383 泛型数组
 */
public class ListOfGeneric<T> {
    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
