package TestNG.Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
interface WithNested {
    class Nested {
        int i;

        public Nested(int i) {
            this.i = i;
        }

        void f() {
            System.out.println("Nested.f");
        }
    }
}

class B2 implements WithNested {
}

public class Test1020 {
    public static void main(String args[]) {
        B2 b = new B2();
        WithNested.Nested ne = new WithNested.Nested(5);
        ne.f();
    }
}
