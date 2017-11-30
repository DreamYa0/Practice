package datastructuresandanalysis.three;


import java.util.Iterator;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 上午9:57
 */
public interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains();

    boolean add();

    boolean remove();

    @Override
    Iterator<T> iterator();
}
