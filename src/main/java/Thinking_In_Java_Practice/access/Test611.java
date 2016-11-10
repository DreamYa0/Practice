package Thinking_In_Java_Practice.access;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test611 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
class Cleanser{

    public void append(String a,String s) {
        s+=a;
    }
    public void dilute() {}
    public void apply() {}
    public void scrub() {}
}
class Detergent extends Cleanser{
    private String s="Cleanser";
    public Detergent(String s) {
        this.s=s;
    }
    public String toString() {
        return s;
    }

}
