package Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/29.
 * P273
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {

                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace();
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
