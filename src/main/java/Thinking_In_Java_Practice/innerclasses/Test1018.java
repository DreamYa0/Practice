package Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
public class Test1018 {
    static class Nested {
        void f() {
            System.out.println("Nested.f");
        }
    }

    public static void main(String args[]) {
        Nested ne = new Nested();
        ne.f();
    }
}

class Other {
    // Specifying the nested type outside
// the scope of the class:
    void f() {
        Test1018.Nested ne =
                new Test1018.Nested();
    }
}
