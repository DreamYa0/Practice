package Thinking_in_Java.generics;

import Thinking_in_Java.net.mindview.util.Generator;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-6.
 *         P364 一个通用的Generator
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
