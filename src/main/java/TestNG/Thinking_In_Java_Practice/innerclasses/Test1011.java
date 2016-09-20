package TestNG.Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P196
 */
class Outer5 {
    private class Inner implements SimpleInterface {
        public void f() {
            System.out.println("Outer5.Inner.f");
        }
    }

    public SimpleInterface get() {
        return new Inner();
    }

    public Inner get2() {
        return new Inner();
    }
}

public class Test1011 {
    public static void main(String args[]) {
        Outer5 out = new Outer5();
        SimpleInterface si = out.get();
        si = out.get2();
// Won't compile -- 'Inner' not visible:
//! Inner i1 = out.get2();
//! Inner i2 = (Inner)si;
    }
}
