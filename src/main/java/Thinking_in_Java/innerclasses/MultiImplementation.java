package Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/16.
 * P205
 */
public class MultiImplementation {
    static void takesD(D d){}
    static void takesE(E e){}
    public static void main(String[] args){
        Z z=new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
class D{}
abstract class E{}
class Z extends D{
    E makeE(){
        return new E() {};
    }
}
