package Thinking_In_Java_Practice.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
enum Note{
    MIDDLE_C,C_SHARP,B_FLAT;
}
public class Test806 {

    public static void tuneAll(Instrument2[] e) {
        for (Instrument2 i : e) {
            i.play(Note.MIDDLE_C);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Instrument2[] orchestra={
                new Wind2(),
                new Percussion2(),
                new Stringed2(),
                new Brass2(),
                new Woodwind2()
        };
        tuneAll(orchestra);//向上转型
        Instrument2 instrument2=new Instrument2();
        System.out.println(instrument2.toString());
    }
}
class Instrument2{
    void play(Note n){
        System.out.println("Instrument.play()"+n);
    }
    public String toString(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
class Wind2 extends Instrument2{
    void play(Note n){
        System.out.println("Wind.play()"+n);
    }
    String what(){
        return "Wind";
    }
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
class Percussion2 extends Instrument2{
    void play(Note n){
        System.out.println("Percussion.play()"+n);
    }
    String what(){
        return "Percussion";
    }
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
class Stringed2 extends Instrument2{
    void play(Note n){
        System.out.println("Stringed.play()"+n);
    }
    String what(){
        return "Stringed";
    }
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
class Brass2 extends Wind2{
    void play(Note n){
        System.out.println("Brass.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Brass");
    }
}
class Woodwind2 extends Wind2{
    void play(Note n){
        System.out.println("Woodwind.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Woodwind");
    }
}

