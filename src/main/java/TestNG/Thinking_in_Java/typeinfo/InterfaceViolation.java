package TestNG.Thinking_in_Java.typeinfo;

import TestNG.Thinking_in_Java.typeinfo.interfacea.A;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-21.
 *         P346 接口与类型信息
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;//向下转型位B
            b.g();
        }
    }
}

class B implements A {

    @Override
    public void f() {

    }

    public void g() {
    }
}
