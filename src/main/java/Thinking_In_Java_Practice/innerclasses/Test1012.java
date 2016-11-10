package Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
public class Test1012 {
    private int i = 10;
    private void f() {
        System.out.println("Test1012.f");
    }
    public void h() {
        new Object() {
            void g() {
                i++;
                f();
            }
        }.g();
        System.out.println("i = " + i);
    }
    public static void main(String args[]) {
        Test1012 ica =
                new Test1012();
        ica.h();
    }
}
