package datastructuresandanalysis;

/**
 * Created by DreamYao on 2016/7/23.
 * P8 使用Object表示泛型
 */
public class MemoryCell {
    private Object storedValue;

    public Object read() {
        return storedValue;
    }

    public void write(Object x) {
        storedValue = x;
    }
}
