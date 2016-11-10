package Thinking_in_Java.typeinfo;

/**
 * Created by DreamYao on 2016/9/1.
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
