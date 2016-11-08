package TestNG.Thinking_in_Java.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/8.
 *         P384 创建泛型数组的唯一方式就是创建一个被擦除类型的新数组，
 *         然后对其转型
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        Object[] oa = gai.rep();
    }
}
