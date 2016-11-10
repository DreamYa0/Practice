package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test505 {
    public void bark() {
        System.out.println("barking");
    }

    public void bark(int i) {
        System.out.println("howling");
    }

    public void bark(String i) {
        System.out.println("barkinghowling");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test505 test505 = new Test505();
        test505.bark();
        test505.bark(1);
        test505.bark("1");
    }

}
