package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test510 {
    protected void finalize() {
        System.out.println("wwewew");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test510 test510 = new Test510();
        test510.finalize();

    }

}
