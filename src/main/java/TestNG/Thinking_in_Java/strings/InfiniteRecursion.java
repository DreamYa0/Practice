package TestNG.Thinking_in_Java.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DreamYao on 2016/7/31.
 * P287 如果想正确的打印对象的内存地址，应该调用Object.toString()方法
 * 所以不该使用this，而是应该调用super.toString()方法
 */
public class InfiniteRecursion {
    public String toString() {
        return "InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
