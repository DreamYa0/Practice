package thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by DreamYao on 2016/7/14.
 * P243适配器的惯用方法，可以选择向前或者向后方向迭代一个单词列表
 */
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not ro be ".split(" ")));
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ral.rebersed()) {
            System.out.print(s + " ");
        }
    }
}

class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    //迭代器
    public Iterable<T> rebersed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
