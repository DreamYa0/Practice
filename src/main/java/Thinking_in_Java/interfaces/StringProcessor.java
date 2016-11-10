package Thinking_in_Java.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P177复用代码
import java.util.Arrays;

public abstract class StringProcessor implements Processor7{

    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s="If she weighs the same as a duck,she's made of wood";
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Apply7.process(new Upcase7(), s);
        Apply7.process(new Downcase7(), s);
        Apply7.process(new Splitter7(), s);

    }

}
class Upcase7 extends StringProcessor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Downcase7 extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}
class Splitter7 extends StringProcessor{
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
interface Processor7{
    String name();
    Object process(Object input);
}
class Apply7{
    public static void process(Processor7 p,Object s) {
        System.out.println("Useing Processor "+p.name());
        System.out.println(p.process(s));
    }
}
