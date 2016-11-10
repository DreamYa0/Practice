package Thinking_in_Java.generics;

import Thinking_in_Java.generics.coffee.Coffee;
import Thinking_in_Java.generics.coffee.CoffeeGenerator;
import Thinking_in_Java.net.mindview.util.Fibonacci;
import Thinking_in_Java.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-6.
 *         P364 用于Generator的泛型方法
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (int i : fnumbers) {
            System.out.print(i + ",");
        }
    }
}
