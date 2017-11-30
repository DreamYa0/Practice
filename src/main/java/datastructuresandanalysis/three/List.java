package datastructuresandanalysis.three;

import java.util.ListIterator;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 上午10:15
 */
public interface List<T> extends Collection<T> {

    T get(int index);

    T set(int index, T newVal);

    void add(int index, T newVal);

    void remove(int index);

    ListIterator<T> listIterator(int pos);
}
