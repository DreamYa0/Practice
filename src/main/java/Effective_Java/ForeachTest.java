package Effective_Java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dreamyao on 2017/3/21.
 * 不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
 方式，如果并发操作，需要对 Iterator 对象加锁。
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        // 以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的结果吗?
        // 反例
        /*for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }*/

        // 正例
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("2".equals(temp)) {
                it.remove();
            }
        }

        System.out.println(a);
    }
}
