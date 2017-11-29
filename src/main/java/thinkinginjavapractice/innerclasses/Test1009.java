package thinkinginjavapractice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P196
 */
public class Test1009 {
    public SimpleInterface get() {
        class SI implements SimpleInterface {
            public void f() {
                System.out.println("SI.f");
            }
        }
        return new SI();
    }

    public static void main(String args[]) {
        SimpleInterface si = new Test1009().get();
        si.f();
    }
}
