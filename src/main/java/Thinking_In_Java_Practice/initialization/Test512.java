package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test512 {

    class Tank{
        boolean a=false;
    }
    protected void finalize() {
        Tank tank=new Tank();
        boolean b = tank.a;
        if (b==false){
            System.out.println("b被回收");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test512 test512=new Test512();
        test512.finalize();

    }

}
