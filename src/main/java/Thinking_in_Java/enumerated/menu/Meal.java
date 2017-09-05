package Thinking_in_Java.enumerated.menu;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/5 13:22
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelect();
                System.out.println(food);
            }
            System.out.println("- - - - -");
        }
    }
}
