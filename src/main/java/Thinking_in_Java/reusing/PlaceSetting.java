package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P132结合使用组合和继承
public class PlaceSetting extends Custom {

    @SuppressWarnings("unused")
    private Spoon spoon;
    @SuppressWarnings("unused")
    private Fork fork;
    @SuppressWarnings("unused")
    private Knife knife;
    @SuppressWarnings("unused")
    private DinnerPlate plate;

    PlaceSetting(int i) {
        super(i + 1);
        // TODO Auto-generated constructor stub
        spoon = new Spoon(i + 2);
        fork = new Fork(i + 3);
        knife = new Knife(i + 4);
        plate = new DinnerPlate(i + 5);
        System.out.println("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        PlaceSetting placeSetting = new PlaceSetting(9);
    }

}

class Plate {
    Plate(int i) {
        System.out.println("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor");
    }
}

class Utensil {
    Utensil(int i) {
        System.out.println("Utensil constructor");
    }
}

class Spoon extends Utensil {

    Spoon(int i) {
        super(i);
        // TODO Auto-generated constructor stub
        System.out.println("Spoon conteuctor");
    }
}

class Fork extends Utensil {

    Fork(int i) {
        super(i);
        // TODO Auto-generated constructor stub
        System.out.println("Fork conteuctor");
    }

}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        // TODO Auto-generated constructor stub
        System.out.println("Knife conteuctor");
    }

}

class Custom {
    Custom(int i) {
        // TODO Auto-generated constructor stub
        System.out.println("Custom conteuctor");
    }
}
