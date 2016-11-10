package Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P195
 */
public class Test1006
        extends SimpleClass {
    public SimpleInterface get() {
        return new Inner();
    }

    public static void main(String args[]) {
        new Test1006().get().f();
    }
}

interface SimpleInterface {
    void f();
}

class SimpleClass {
    protected class Inner implements SimpleInterface {
        // Force constructor to be public:
        public Inner() {
        }

        public void f() {
        }
    }
}
