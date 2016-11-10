package Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P201嵌套类
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {
        }

        static int x = 10;

        //嵌套类
        static class AnotherLevel {
            public static void f() {
            }

            static int x = 10;
        }
    }

    //创建Destination引用
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    //创建Contents引用
    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
        System.out.println(c);
        System.out.println(d);
    }
}
