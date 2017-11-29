package thinkinginjavapractice.holding;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1102 {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for(Integer i : c)
            System.out.print(i + ", ");
    }
}
