package TestNG.Thinking_in_Java.net.mindview.util;

import TestNG.Thinking_in_Java.generics.coffee.Coffee;
import org.apache.poi.ss.formula.functions.T;

import java.util.Random;

/**
 * Created by dreamyao on 16-10-6.
 */
public class Fibonacci implements Generator<Integer> {
    @Override
    public Integer next() {
        Random rand = new Random(47);
        int integer=rand.nextInt();
        return integer;
    }
}
