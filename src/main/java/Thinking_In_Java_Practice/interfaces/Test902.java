package Thinking_In_Java_Practice.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test902 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        B3 b3=new B3();
        b3.print();

    }

}
abstract class A3{
    public abstract void print();
    A3(){
        print();
    }
}
class B3 extends A3{
    public int i=3;
    public void print() {
        System.out.println(i);
    }

}
