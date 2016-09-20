package TestNG.Thinking_in_Java.interfaces;

import java.util.Arrays;

/**
 * Created by DreamYao on 2016/5/19.
 */
public abstract class StringProcessor_1 implements Processor7 {
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static String s = "If she weighs the same as a duck,she's made of wood";

    public static void main(String[] args) {
        Apply7.process(new Upcase7(), s);
        Apply7.process(new Downcase7(), s);
        Apply7.process(new Splitter7(), s);
    }
}

class Upcase8 extends StringProcessor_1 {

    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase8 extends StringProcessor_1 {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter8 extends StringProcessor_1 {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}