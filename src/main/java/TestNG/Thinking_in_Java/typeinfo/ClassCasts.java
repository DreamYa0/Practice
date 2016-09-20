package TestNG.Thinking_in_Java.typeinfo;

/**
 * Created by DreamYao on 2016/9/1.
 * P322 新的转型语法
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;
    }
}

class Building {
}

class House extends Building {
}
