package datastructuresandanalysis.three;


import java.util.Iterator;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 上午10:03
 */
public class CollectionTest {

    public static <T> void print(Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            System.out.println(t);
        }
    }

    public static void makeList(List<Integer> list, int n) {
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(0,i);
        }
    }
}
