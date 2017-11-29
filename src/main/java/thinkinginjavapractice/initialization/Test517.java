package thinkinginjavapractice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test517 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A.B((Object[])new String[] { "www", "weww" });

    }

}

class A {
    static void B(Object... a) {
        for (Object b : a) {
            System.out.println(b);
        }
    }
}
