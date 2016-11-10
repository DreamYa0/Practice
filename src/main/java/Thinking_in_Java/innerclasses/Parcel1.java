package Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/5/29.P190创建内部类
 */
public class Parcel1 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readlabel() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        System.out.println(c.value());
        Destination d = new Destination(dest);
        System.out.println(d.readlabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmaina");
    }
}
