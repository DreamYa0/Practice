package thinkinginjava.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P153可扩展性
public class Music3 {

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
        Instrument2 on=new Wind2();//也是向上转型
        on.play(Note.B_FLAT);
    }
}
class Instrument2{
    void play(Note n){
        System.out.println("Instrument.play()"+n);
    }
    String what(){
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
