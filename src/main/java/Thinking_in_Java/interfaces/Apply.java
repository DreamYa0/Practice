package Thinking_in_Java.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P174完全解耦
import java.util.Arrays;

public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(String input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(String input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(String input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
