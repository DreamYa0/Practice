package Thinking_In_Java_Practice.holding;

import java.util.*;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1111 {
    public static void printToStrings(Iterator<?> it) {
        while (it.hasNext())
            System.out.println(it.next().toString());
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        List<Collection<String>> ca =
                Arrays.<Collection<String>>asList(
                        new ArrayList<String>(),
                        new LinkedList<String>(),
                        new HashSet<String>(),
                        new TreeSet<String>());
        for (Collection<String> c : ca)
            Test1104.fill(c);
        for (Collection<String> c : ca)
            printToStrings(c.iterator());
    }
}
