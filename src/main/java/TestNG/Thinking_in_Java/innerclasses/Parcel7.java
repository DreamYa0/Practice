package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P197匿名内部类
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {//Insert a class definition
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
