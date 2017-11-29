package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.
 */
class Outer3 {
    class Inner {
        { System.out.println("Inner created"); }
    }
}
public class Test1005 {
    public static void main(String args[]) {
        Outer3 o = new Outer3();
        Outer3.Inner i = o.new Inner();
    }
}
