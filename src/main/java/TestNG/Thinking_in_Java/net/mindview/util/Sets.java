package TestNG.Thinking_in_Java.net.mindview.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/15.
 *         P367 一个Set实用工具
 */
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;//返回Set并集
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;//返回Set交集
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;//返回移除Subset包含元素后的元素
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));//返回Set交集以为的元素
    }
}
