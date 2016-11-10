package Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class NewVarArgs {

    static void printArray(Object... args){
        for(Object obj:args){
            System.out.printf(obj+" ");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        printArray(new Integer(47),new Float(3.14),new Double(11.11));
        printArray(47,3.14F,11,11);
        printArray("one","two","three");
        printArray(new A(),new A(),new A());
        printArray((Object[])new String[]{"1","2","3","4","5"});//转化为Object数组
        printArray();

    }

}
class A{}
