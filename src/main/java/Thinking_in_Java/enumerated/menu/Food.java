package Thinking_in_Java.enumerated.menu;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/5 13:13
 */
public interface Food {

    enum Appertizer implements Food{
        SALAD,SOUP,SPRING_ROLLS;
    }

    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
    }

    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CRAMEL;
    }

    enum Coffee implements Food{
        BLACKE_COFFEE;
    }
}
