package TestNG.Thinking_In_Java_Practice.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test720 {
    public static void main(String[] args) {
        OverridingPrivate2 op2=new OverridingPrivate2();
        op2.f();
        op2.g();
    }

}
class WithFinals{
    private final void f(){
        System.out.println("WithFinals.f()");
    }
    private void g(){
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals{

    public void f(){
        System.out.println("OverridingPrivate.f()");
    }

    private void s(){
        System.out.println("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate{

    public void f(){
        System.out.println("OverridingPrivate2.f()");
    }

    public void g(){
        System.out.println("OverridingPrivate2.g()");
    }
}
