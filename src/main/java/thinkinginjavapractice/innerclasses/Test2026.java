package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
class WithNonDefault {
    class Inner {
        int i;

        public Inner(int i) {
            this.i = i;
        }

        public Inner() {
            i = 47;
        }

        public void f() {
            System.out.println("Inner.f");
        }
    }
}

public class Test2026 {
    class Inner2 extends WithNonDefault.Inner {
        // Won't compile -- WithNonDefault not available:
//! public Inner2(int i) {
//! super(i);
//! }
        public Inner2(WithNonDefault wnd, int i) {
            wnd.super(i);
        }

        public void f() {
            System.out.println("Inner2.f");
            super.f();
        }
    }

    public static void main(String args[]) {
        WithNonDefault wnd = new WithNonDefault();
        Test2026 ici =
                new Test2026();
        Inner2 i2 = ici.new Inner2(wnd, 47);
        i2.f();
    }
}
