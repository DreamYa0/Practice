package thinkinginjavapractice.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P140向上转型
public class Test716 extends Amphibian {
    public Test716(int a) {
        super(a);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test716 test716 = new Test716(10);
        Amphibian.name(test716);
    }

}

class Amphibian {
    @SuppressWarnings("unused")
    private int a;

    protected Amphibian(int a) {
        this.a = a;
        for (int i = 0; i < 100; i++) {
            a++;
        }
        System.out.println(a);
    }

    static void name(Amphibian A) {
        System.out.println(A);
    }
    public void B(int c ) {
        System.out.println(c);
    }
}
