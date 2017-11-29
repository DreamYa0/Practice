package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
public class Test1019 {
    class Inner1 {
        class Inner2 {
            void f() {
            }
        }

        Inner2 makeInner2() {
            return new Inner2();
        }
    }

    Inner1 makeInner1() {
        return new Inner1();
    }

    static class Nested1 {
        static class Nested2 {
            void f() {
            }
        }

        void f() {
        }
    }

    public static void main(String args[]) {
        new Test1019.Nested1().f();
        new Test1019.Nested1.Nested2().f();
        Test1019 x1 = new Test1019();
        Test1019.Inner1 x2 = x1.makeInner1();
        Test1019.Inner1.Inner2 x3 =
                x2.makeInner2();
        x3.f();
    }
}
