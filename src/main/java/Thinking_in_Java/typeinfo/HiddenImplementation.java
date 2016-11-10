package Thinking_in_Java.typeinfo;

import Thinking_in_Java.typeinfo.interfacea.A;
import Thinking_in_Java.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-21.
 *         P347 通过反射可以用所以的方法包括私有方法
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Compile error: cannot find symbol 'C';
        /*if (a instanceof C) {
            C c=(C)a;
            c.g();
        }*/
        //Oops! Reflection still allows us to call g();
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
