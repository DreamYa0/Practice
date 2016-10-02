package TestNG.Thinking_in_Java.net.mindview.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-2.
 *         P362 杠杆利用类型参数推断
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashedMap();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> IList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.IList();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
    }
}
