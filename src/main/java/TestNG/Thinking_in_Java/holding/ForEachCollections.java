package TestNG.Thinking_in_Java.holding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by DreamYao on 2016/7/14.
 * P241 Foreach与迭代器
 */
public class ForEachCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.println("'" + s + "' ");
        }
    }
}
