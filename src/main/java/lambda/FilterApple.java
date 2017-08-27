package lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/20 21:20
 */
public class FilterApple {

    public List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = Lists.newArrayList();
        inventory.forEach(apple -> {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        });
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = Lists.newArrayList();
        inventory.forEach(apple -> {
            if (p.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }
}
