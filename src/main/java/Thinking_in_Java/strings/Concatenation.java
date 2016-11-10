package Thinking_in_Java.strings;

/**
 * Created by DreamYao on 2016/7/31.
 * P284 重载 + 与StringBuilder
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
