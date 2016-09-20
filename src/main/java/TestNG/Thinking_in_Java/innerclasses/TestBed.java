package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/11.
 * P203接口内部的类
 */
public class TestBed {
    public void f(){
        System.out.println("f()");
    }
    public static class Tester{
        public static void main(String[] args){
            TestBed t=new TestBed();
            t.f();
        }
    }
}
