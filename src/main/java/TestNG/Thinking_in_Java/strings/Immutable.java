package TestNG.Thinking_in_Java.strings;

/**
 * Created by DreamYao on 2016/7/29.
 * P283 不可变String
 */
public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
