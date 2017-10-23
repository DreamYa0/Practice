package thinkinginjava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DreamYao on 2016/8/16.
 * P302组
 */
public class Groups {
    static public final String POEM = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe,\n" +
            "Beware the Jubjub bird,and shun\n" +
            "The jaws that bite,the claws that catch.\n" +
            "Beware the Jubjub bird,and shun\n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.println("[" + m.group(j) + "]");
            }
            System.out.println();
        }
    }
}
