package Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P197匿名内部类
 */
public class Parcel7b {
    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return 1;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public MyContents myContents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
        MyContents m = p.myContents();
    }
}
