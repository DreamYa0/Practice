package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.
 */
public class Test1007 {
    private int i = 10;
    private void f() {
        System.out.println("Test1007.f()");
    }
    class Inner {
        void g() {
            i++;
            f();
        }
    }
    public void h() {
        Inner in = new Inner();
        in.g();
        System.out.println("i = " + i);
    }
    public static void main(String args[]) {
        Test1007 ica = new Test1007();
        ica.h();
    }
}
