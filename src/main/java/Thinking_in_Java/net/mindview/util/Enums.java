package Thinking_in_Java.net.mindview.util;

import java.util.Random;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/5 12:58
 */
public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
