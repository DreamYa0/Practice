package TestNG.Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P151产生正确的行为
import java.util.Random;

public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Shape1[] s = new Shape1[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        for (Shape1 shape : s) {
            shape.draw();
            shape.name();
        }

    }

}

class Shape1 {
    public void draw() {
    }

    public void erase() {
    }
    public void name() {
        System.out.println("wewew");
    }
}

class Circle1 extends Shape1 {


    public void draw() {
        System.out.println("Circle.draw()");
    }


    public void erase() {
        System.out.println("Circle.erase()");
    }
    public void name() {
        System.out.println("wwwwwww");
    }
}

class Square extends Shape1 {
    public void draw() {
        System.out.println("Square.draw()");
    }

    public void erase() {
        System.out.println("Square.erase()");
    }
    public void name() {
        System.out.println("wwwwwww");
    }
}

class Triangle1 extends Shape1 {
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    public void erase() {
        System.out.println("Triangle.erase()");
    }
    public void name() {
        System.out.println("wwwwwww");
    }
}

class RandomShapeGenerator {//函数工场
    private Random rand = new Random(47);

    public Shape1 next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle1();
            case 1:
                return new Square();
            case 2:
                return new Triangle1();
        }
    }
}
