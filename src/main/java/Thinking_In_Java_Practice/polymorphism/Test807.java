package Thinking_In_Java_Practice.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
enum Note1{
    MIDDLE_C,C_SHARP,B_FLAT;
}
public class Test807 {

    public static void tuneAll(Instrument3[] e) {
        for (Instrument3 i : e) {
            i.play(Note1.MIDDLE_C);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Instrument3[] orchestra={
                new Wind3(),
                new Percussion3(),
                new Stringed3(),
                new Brass3(),
                new Woodwind3()
        };
        tuneAll(orchestra);//向上转型
        Instrument3 instrument2=new Instrument3();
        System.out.println(instrument2.toString());
    }
}
class Instrument3{
    void play(Note1 n){
        System.out.println("Instrument.play()"+n);
    }
    public String toString(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjusting Instrument");
    }

}
class Wind3 extends Instrument3{
    void play(Note1 n){
        System.out.println("Wind.play()"+n);
    }
    String what(){
        return "Wind";
    }
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
class Percussion3 extends Instrument3{
    void play(Note1 n){
        System.out.println("Percussion.play()"+n);
    }
    String what(){
        return "Percussion";
    }
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
class Stringed3 extends Instrument3{
    void play(Note1 n){
        System.out.println("Stringed.play()"+n);
    }
    String what(){
        return "Stringed";
    }
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
class Brass3 extends Wind3{
    void play(Note1 n){
        System.out.println("Brass.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Brass");
    }
}
class Woodwind3 extends Wind3{
    void play(Note1 n){
        System.out.println("Woodwind.play()"+n);
    }
    void adjust(){
        System.out.println("Adjusting Woodwind");
    }
}


