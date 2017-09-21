package lambda;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/21 10:59
 */
public class TestList {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        Set<Integer> set = Sets.newHashSet();
        set.addAll(integerList);
        System.out.println(set.toString());
    }
}
