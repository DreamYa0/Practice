package Thinking_in_Java.typeinfo;

/**
 * Created by DreamYao on 2016/9/1.
 * P320 泛华的Class引用
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
    }
}
