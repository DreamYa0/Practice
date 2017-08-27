package lambda;

import lombok.Data;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/20 21:19
 */
@Data
public class Apple {

    private String color;
    private Integer weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
