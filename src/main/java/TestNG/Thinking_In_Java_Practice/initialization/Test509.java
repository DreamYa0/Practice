package TestNG.Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test509 {
    int b;

    public Test509(int a) {
        b = a;
        for (int i = 0; i < 100; i++) {
            b++;
        }
        // TODO Auto-generated constructor stub
    }

    public Test509() {
        // TODO Auto-generated constructor stub
        this(0);
        System.out.println(b);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Test509();

    }
}
