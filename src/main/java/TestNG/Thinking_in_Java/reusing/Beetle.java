package TestNG.Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P156继承与初始化
public class Beetle extends Insert {

    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);

    }

    @SuppressWarnings("unused")
    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Beetle constructor");
//		Beetle beetle = new Beetle();

    }

}

class Insert {
    private int i = 9;
    protected int j;

    Insert() {
        System.out.println("i= " + i + ", j =" + j);
        j = 39;
    }

    @SuppressWarnings("unused")
    private static int x1 = printInit("static Insert.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
