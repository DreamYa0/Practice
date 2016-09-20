package TestNG.Thinking_In_Java_Practice.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1117 {
    public static void main(String args[]) {
        Map<String, Gerbil> map = new HashMap<String, Gerbil>();
        map.put("Fuzzy", new Gerbil(1));
        map.put("Spot", new Gerbil(2));
        map.put("Joe", new Gerbil(3));
        map.put("Ted", new Gerbil(4));
        map.put("Heather", new Gerbil(5));
        Iterator<Map.Entry<String, Gerbil>> it =
                map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Gerbil> entry = it.next();
            System.out.print(entry.getKey() + ": ");
            entry.getValue().hop();
        }
    }
}