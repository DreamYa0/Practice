package Thinking_in_Java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DreamYao on 2016/8/24.
 * P307 rest()
 */
public class Resetting {
    public static void main(String[] args) throws Exception {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find()) {
            System.out.println(m.group() + "");
        }
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.println(m.group() + "");
        }
    }
}
