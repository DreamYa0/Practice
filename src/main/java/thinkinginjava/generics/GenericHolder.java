package thinkinginjava.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/24.
 *         P379
 */
public class GenericHolder<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> genericHolder = new GenericHolder<>();
        genericHolder.setObj("Item");
        String s = genericHolder.getObj();
        System.out.println(s);
    }
}
