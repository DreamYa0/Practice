package spring.reflect;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-25.
 *         P52
 */
public class PrivateCar {
    private String color;

    private void drive() {
        System.out.println("drive private car! the color is:" + color);
    }
}
