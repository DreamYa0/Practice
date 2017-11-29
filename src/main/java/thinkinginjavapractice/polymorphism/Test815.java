package thinkinginjavapractice.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P164
public class Test815 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new RoundGlyph(5);

    }

}
class Glyph{
    final void RectangularGlyph(){
        System.out.println("xxxsxs");
    }
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        RectangularGlyph();
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

