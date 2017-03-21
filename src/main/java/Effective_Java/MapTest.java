package Effective_Java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreamyao on 2017/3/21.
 */
public class MapTest {
    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        // 正常方式遍历Map
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        // 使用Java8的foreach+lambda表达式遍历Map
        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });

    }
}
