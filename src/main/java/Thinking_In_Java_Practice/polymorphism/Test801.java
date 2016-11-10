package Thinking_In_Java_Practice.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P150
public class Test801 {

    public static void ride(Unicycle i) {
        i.name1("12", "32");
        i.balance();
    }

    public static void ride(Bicycle i) {
        i.name2(12, 32);
        i.balance();
    }

    public static void ride(Tricycle i) {
        i.name3(12f, 32f);
    }

    public static void ride(Cycle i) {
        System.out.println(i.wheels(4));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        Cycle cycle = new Cycle();
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
        ride(cycle);
    }
}

class Cycle {
    public void name(int a, int b) {
        System.out.println(a * b);
    }

    public int wheels(int c) {
        return c;
    }
}

class Unicycle extends Cycle {
    public void name1(String a, String b) {
        System.out.println(a + b);
    }
    public void balance() {
        System.out.println("dedde");
    }
}

class Bicycle extends Cycle {
    public void name2(double a, double b) {
        System.out.println(a / b);
    }
    public void balance() {
        System.out.println("ererer");
    }
}

class Tricycle extends Cycle {
    public void name3(float a, float b) {
        System.out.println(a - b);
    }
}
