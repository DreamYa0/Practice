package thinkinginjava.exceptions;

/**
 * Created by DreamYao on 2016/7/20.
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("Form f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
