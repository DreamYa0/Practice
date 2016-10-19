package TestNG.Thinking_in_Java.generics;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/19.
 *         P372 擦除的神秘之处
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
