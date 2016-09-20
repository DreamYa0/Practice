package TestNG.Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P149再论向上转型
public class Music {

    public static void tune(Wind i) {
        i.play(Note.C_SHARP);
    }
    public static void tune(Brass i) {
        i.play(Note.C_SHARP);
    }
    public static void tune(Stringed i) {
        i.play(Note.C_SHARP);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Wind flute=new Wind();
        Stringed violin=new Stringed();
        Brass frenchHorn=new Brass();
        Instrument instrument=new Wind();
        instrument.play(Note.MIDDLE_C);
        tune(frenchHorn);
        tune(violin);
        tune(flute);
    }

}
enum Note{
    MIDDLE_C,C_SHARP,B_FLAT;
}
class Instrument{
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}
class Wind extends Instrument{
    public void play(Note n) {
        System.out.println("Wind.play()"+n);
    }
}
class Brass extends Instrument{
    public void play(Note n) {
        System.out.println("Brass.play()"+n);
    }
}
class Stringed extends Instrument{
    public void play(Note n) {
        System.out.println("Stringed.play()"+n);
    }
}
