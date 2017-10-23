package thinkinginjava.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Music4 {

    public static void tuneAll(Instrument5[] e) {
        for (Instrument5 i : e) {
            i.play(Note3.MIDDLE_C);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Instrument5[] orchestra={
                new Wind5(),
                new Percussion5(),
                new Stringed5(),
                new Brass5(),
                new Woodwind5()
        };
        tuneAll(orchestra);//向上转型
        Instrument5 on=new Wind5();//也是向上转型
        on.play(Note3.B_FLAT);
    }
}
enum Note3{
    MIDDLE_C,C_SHARP,B_FLAT;
}
abstract class Instrument5{
    public int i;
    public abstract void play(Note3 n);
    String what(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
class Wind5 extends Instrument5{
    public void play(Note3 n){
        System.out.println("Wind.play()"+n);
    }
    String what(){
        return "Wind";
    }
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
class Percussion5 extends Instrument5{
    public void play(Note3 n){
        System.out.println("Percussion.play()"+n);
    }
    String what(){
        return "Percussion";
    }
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
class Stringed5 extends Instrument5{
    public void play(Note3 n){
        System.out.println("Stringed.play()"+n);
    }
    String what(){
        return "Stringed";
    }
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
class Brass5 extends Wind5{
    public void play(Note3 n){
        System.out.println("Brass.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Brass");
    }
}
class Woodwind5 extends Wind5{
    public void play(Note3 n){
        System.out.println("Woodwind.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Woodwind");
    }
}