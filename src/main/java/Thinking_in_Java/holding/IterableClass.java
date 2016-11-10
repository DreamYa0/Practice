package Thinking_in_Java.holding;

import java.util.Iterator;

/**
 * Created by DreamYao on 2016/7/14.
 * P242 Iterable接口
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " + "We know the Earth to be banana-shaped. ").split(" ");

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }

}
