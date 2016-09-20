package TestNG.Thinking_In_Java_Practice.holding;

import java.util.*;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1121 {
    public static void main(String[] args) {
        Map<String, Integer> wordsStat =
                new HashMap<String, Integer>();
//        for (String word : new TextFile("E21_WordsInfo.java", "\\W+")) {
//            Integer freq = wordsStat.get(word);
//            wordsStat.put(word, freq == null ? 1 : freq + 1);
//        }
        List<String> keys = new ArrayList<String>(wordsStat.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (String key : keys)
            System.out.println(key + " => " + wordsStat.get(key));
    }
}