package thinkinginjava.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P172接口
public class Music5 {

    static void tuneAll(Instrument6[] e){
        for (Instrument6 i : e) {
            i.play(Note6.MIDDLE_C);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Instrument6[] orchestra={
                new Wind6(),
                new Percussion6(),
                new Strinded6(),
                new Brass6(),
                new Woodwind6()
        };
        tuneAll(orchestra);//向上转型
    }
}
enum Note6{
    MIDDLE_C,C_SHARP,B_FLAT;
}
interface Instrument6{
    int VALUE=5;
    void play(Note6 n);
    void adjust();
}
class Wind6 implements Instrument6{
    public void play(Note6 n) {
        System.out.println(this + ".play()"+n);
    }
    public String toString() {
        return "Wind6";
    }
    public void adjust() {
        System.out.println(this +".adjust()");
    }
}
class Percussion6 implements Instrument6{
    public void play(Note6 n) {
        System.out.println(this + ".play()"+n);
    }
    public String toString() {
        return "Percussion";
    }
    public void adjust() {
        System.out.println(this +".adjust()");
    }
}
class Strinded6 implements Instrument6{
    public void play(Note6 n) {
        System.out.println(this + ".play()"+n);
    }
    public String toString() {
        return "Strinded";
    }
    public void adjust() {
        System.out.println(this +".adjust()");
    }
}
class Woodwind6 extends Wind6{
    public String toString() {
        return "Woodwind";
    }
}
class Brass6 extends Wind6{
    public String toString() {
        return "Brass";
    }
}
