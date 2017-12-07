package datastructuresandanalysis.three;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 上午10:27
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;

    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public void set(int idx, T newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        theItems[idx] = newVal;

    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public void remove(int idx) {
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T t : this) {
            action.accept(t);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
