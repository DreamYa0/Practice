package TestNG.Thinking_in_Java.typeinfo.packageaccess;

import TestNG.Thinking_in_Java.typeinfo.interfacea.A;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-21.
 *         P347
 */
public class HiddenC {
    public static A makeA() {
        return new C();
    }
}

class C implements A {

    @Override
    public void f() {
        System.out.println("Public C.f()");
    }

    public void g() {
        System.out.println("Public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
