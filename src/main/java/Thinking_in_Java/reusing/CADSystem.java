package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P133确保正确清理
class Shape {
    Shape(int i) {
        // TODO Auto-generated constructor stub
        System.out.println("Space constructor");
    }
    void dispose(){
        System.out.println("Space dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        // TODO Auto-generated constructor stub
        System.out.println("Drawing constructor");
    }

    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        // TODO Auto-generated constructor stub
        System.out.println("Drawing constructor");
    }

    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;

    Line(int start, int end) {
        super(start);
        // TODO Auto-generated constructor stub
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line: " + start + "," + end);
    }

    void dispose() {
        System.out.println("Erasing Line: " + start + "," + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {

    private Circle circle;
    private Triangle triangle;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        // TODO Auto-generated constructor stub
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
            circle = new Circle(1);
            triangle = new Triangle(1);
            System.out.println("Combined constructor");
        }
    }

    public void dispose() {
        System.out.println("CADSystem.dispose()");
        triangle.dispose();
        circle.dispose();
    }

    public static void main(String[] args) {
        CADSystem cadSystem = new CADSystem(47);
        try {

        } finally {
            // TODO: handle finally clause
            cadSystem.dispose();
        }
    }
}

