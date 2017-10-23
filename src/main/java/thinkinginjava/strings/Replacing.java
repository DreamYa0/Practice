package thinkinginjava.strings;

/**
 * Created by DreamYao on 2016/8/13.
 * P297 split()重载方法
 */
public class Replacing {
    static String s=Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+","located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
