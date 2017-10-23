package thinkinginjava.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P163构造器内部的多态方法的行为
public class PolyConstructors {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new RoundGlyph(5);

    }

}
class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph{
    private int radius=1;
    RoundGlyph(int r) {
        // TODO Auto-generated constructor stub
        radius=r;
        System.out.println("RoundGlyph.RoundGlyph(), radius= "+radius);
    }
    void draw(){
        System.out.println("RoundGlyph.draw(), radius = "+radius);
    }
}
