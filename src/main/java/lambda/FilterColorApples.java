package lambda;

import java.util.function.Predicate;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/20 21:34
 */
public class FilterColorApples implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
