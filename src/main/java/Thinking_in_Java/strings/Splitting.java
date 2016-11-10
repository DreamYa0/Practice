package Thinking_in_Java.strings;

import java.util.Arrays;

/**
 * Created by DreamYao on 2016/8/13.
 * P296 正则表达式
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery,you must" + "cut down the mightiest tree in the forest..." +
            "with... a herring";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
