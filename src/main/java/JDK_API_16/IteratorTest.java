package JDK_API_16;

import java.util.*;

/**
 * Created by DreamYao on 2016/11/24.
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 76, 199, 3323, 57, 4545);
        Collections.sort(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer) iterator.next();
            System.out.println(integer);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(11);
        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(17);
        arrayList.add(14);
        arrayList.add(12);
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(10);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //Collections.binarySearch()返回的是被找元素的索引，使用二分搜索前先对list进行排序
        System.out.println(Collections.binarySearch(arrayList, 12));
        int[] ints = {1, 343, 4, 56, 7, 7, 3, 43, 1, 445, 8, 36, 45, 325, 354, 157, 9595};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
