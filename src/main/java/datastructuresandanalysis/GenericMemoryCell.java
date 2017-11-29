package datastructuresandanalysis;

/**
 * Created by DreamYao on 2016/7/23.
 */
public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}
