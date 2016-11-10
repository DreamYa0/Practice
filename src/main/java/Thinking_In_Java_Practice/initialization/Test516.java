package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test516 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        name(new Object[] { "aada", "adsds", "wdwdw" });

    }

    public static void name(Object[] args) {
        for (Object s : args) {
            System.out.println(s);
        }
    }
}
