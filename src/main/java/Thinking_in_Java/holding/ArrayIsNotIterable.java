package Thinking_in_Java.holding;

import java.util.Arrays;

/**
 * Created by DreamYao on 2016/7/14.
 * P242 foreach可以用于数组和其他任何Iterable
 * 把数组当作一个Iterable参数传递或导致失败，这说明
 * 不存在任何从数组到Iterable的自动转换，必须手工执行这种转换
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
