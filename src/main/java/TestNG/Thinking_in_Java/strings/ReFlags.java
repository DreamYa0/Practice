package TestNG.Thinking_in_Java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DreamYao on 2016/8/24.
 * P305 通过或(|)操作符组合多个标记的功能
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher("java has regex\njava has regex\n"
                + "JAVA has pretty good regular expressions\n"
                + "Regular expressions are in Java");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
