package Thinking_in_Java.holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by DreamYao on 2016/7/5.
 * P234 Map
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer frep = m.get(r);//自动包装机制
            m.put(r, frep == null ? 1 : frep + 1);
        }
        System.out.println(m);
    }
}
