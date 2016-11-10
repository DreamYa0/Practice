package Thinking_in_Java.typeinfo;

/**
 * Created by DreamYao on 2016/9/1.
 * P320
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
