package Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P198
 */
public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            {System.out.println("Inside instance initializer");}
            @Override
            public void f() {
                System.out.println("In anonymous f()");

            }
        };
    }
    public static void main(String[] args){
        Base base=getBase(47);
        base.f();
    }
}
abstract class Base{
    public  Base(int i){
        System.out.println("Base constructor, i="+i);
    }
    public abstract void f();
}

