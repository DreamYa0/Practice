package TestNG.Thinking_in_Java.generics;

import TestNG.Thinking_in_Java.net.mindview.util.Generator;

import java.util.BitSet;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-6.
 *         P365
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
