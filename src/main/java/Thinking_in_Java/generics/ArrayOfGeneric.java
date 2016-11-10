package Thinking_in_Java.generics;


/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/8.
 *         P384 泛型数组
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
    }
}
