package Thinking_in_Java.enumerated.menu;

import Thinking_in_Java.net.mindview.util.Enums;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/5 13:18
 */
public enum  Course {
    APPETIZER(Food.Appertizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelect(){
        return Enums.random(values);
    }
}
