package TestNG.Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test504 {
    public Test504() {
        System.out.println("dsdsds");
    }

    public Test504(String aString) {
        System.out.println("aSting"+" "+aString);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Test504();
        new Test504("10");

    }

}

