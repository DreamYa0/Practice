package Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class LabeledWhile {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i = 0;
        outer: while (true) {
            System.out.println("outer while loop");
            while (true) {
                i++;
                System.out.println("i=" + i);
                if (i == 1) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("continue outer");
                    continue outer;
                }
                if (i == 5) {
                    System.out.println("break");
                    break;
                }
                if (i == 7) {
                    System.out.println("break outer");
                    break outer;
                }
            }
        }
    }
}
