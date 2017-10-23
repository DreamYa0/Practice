package thinkinginjava.net.mindview.util;

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
