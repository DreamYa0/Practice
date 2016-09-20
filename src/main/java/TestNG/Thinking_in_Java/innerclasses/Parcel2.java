package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/1.P191
 */
public class Parcel2 {
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

    public Destination to(String s) {
        return new Destination(s);
    }

    //返回Contents内部类引用的方法
    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readlabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
        System.out.println(d.readlabel());
    }
}
