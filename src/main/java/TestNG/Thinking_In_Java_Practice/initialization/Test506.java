package TestNG.Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test506 {
    public void bark(int a, String b) {
        System.out.printf("int:" + a + ",String:" + b+"\n");
    }

    public void bark(String b, int a) {
        System.out.println("String:" + b + ",int:" + a);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test506 test506 = new Test506();
        test506.bark(10, "wao");
        test506.bark("wao", 10);

    }

}
