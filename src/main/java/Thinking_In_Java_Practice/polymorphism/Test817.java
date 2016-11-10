package Thinking_In_Java_Practice.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P168
public class Test817 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cycle4[] cycles={new Unicycle4(),new Bicycle4(),new Tricycle4()};
        for (Cycle4 cycle : cycles) {

            ((Unicycle4)cycle).balance();
            ((Bicycle4)cycle).balance();
        }
    }
}

class Cycle4 {
    public void name(int a, int b) {
        System.out.println(a * b);
    }

    public int wheels(int c) {
        return c;
    }
}

class Unicycle4 extends Cycle4 {
    public void name1(String a, String b) {
        System.out.println(a + b);
    }
    public void balance() {
        System.out.println("dedde");
    }
}

class Bicycle4 extends Cycle4 {
    public void name2(double a, double b) {
        System.out.println(a / b);
    }
    public void balance() {
        System.out.println("ererer");
    }
}

class Tricycle4 extends Cycle4 {
    public void name3(float a, float b) {
        System.out.println(a - b);
    }
}

