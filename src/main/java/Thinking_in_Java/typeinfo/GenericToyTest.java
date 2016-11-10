package Thinking_in_Java.typeinfo;

/**
 * Created by DreamYao on 2016/9/1.
 * P322
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
