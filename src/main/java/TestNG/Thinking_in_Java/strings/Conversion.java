package TestNG.Thinking_in_Java.strings;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Created by DreamYao on 2016/8/8.
 * P292 Formatter转换
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u='a'");
        f.format("s:%s\n", u);
        f.format("c:%c\n", u);
        f.format("b:%b\n", u);
        f.format("h:%h\n", u);
        int v = 121;
        System.out.println("v=121");
        f.format("d:%d\n", v);
        f.format("c:%c\n", v);
        f.format("b:%b\n", v);
        f.format("s:%s\n", v);
        f.format("x:%x\n", v);
        f.format("h:%h\n", v);
        BigInteger w = new BigInteger("50000000000000000");
        System.out.println("w=new BigInteger(\"50000000000000000\")");
        f.format("d:%d\n", w);
        f.format("b:%b\n", w);
        f.format("s:%s\n", w);
        f.format("x:%x\n", w);
        f.format("h:%h\n", w);
    }
}
