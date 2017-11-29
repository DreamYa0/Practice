package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 */
public class Test1013 {
    public SimpleInterface get() {return new SimpleInterface() {
        public void f() {
            System.out.println("SimpleInterface.f");
        }
    };
    }
    public static void main(String args[]) {
        SimpleInterface si =
                new Test1013().get();
        si.f();
    }
}
