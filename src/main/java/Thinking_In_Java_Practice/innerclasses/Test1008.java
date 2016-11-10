package Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P195
 */
class Outer4 {
    class Inner {
        private int j;

        private void h() {
            System.out.println("Inner.h called");
            System.out.println("Inner.j = " + j);
        }
    }

    public void testInnerAccess() {
        Inner i = new Inner();
        i.j = 47;
        i.h();
    }
}

public class Test1008 {
    public static void main(String args[]) {
        Outer4 o = new Outer4();
        o.testInnerAccess();
    }
}
