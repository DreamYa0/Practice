package TestNG.Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test502 {

    static String aString = "a";

    public Test502(String bString) {
        // TODO Auto-generated constructor stub
        System.out.println(bString);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Test502("b");
        System.out.println(aString);
    }
}
