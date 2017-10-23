package thinkinginjava.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DreamYao on 2016/9/1.
 * P321 泛型类语法
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}
