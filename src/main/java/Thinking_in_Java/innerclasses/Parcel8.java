package Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P197匿名内部类
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}
