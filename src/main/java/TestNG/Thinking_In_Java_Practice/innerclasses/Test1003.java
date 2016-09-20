package TestNG.Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.
 */
class Outer2 {
    private final String data;
    class Inner {
        public String toString() { return data; }
    }
    Outer2(String data) { this.data = data; }
    Inner getInner() { return new Inner(); }
}
public class Test1003 {
    public static void main(String[] args) {
        Outer2 o = new Outer2("Inner accessing outer!");
        Outer2.Inner i = o.getInner();
        System.out.println(i.toString());
    }
}