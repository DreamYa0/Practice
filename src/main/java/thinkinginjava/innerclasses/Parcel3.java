package thinkinginjava.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P193嵌套类(静态内部类)
 */
public class Parcel3 {
    class Contents{
        private int i=11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label=whereTo;
        }
        String readLabel(){
            return label;
        }
    }
    public static void main(String[] args){
        Parcel3 p=new Parcel3();
        Parcel3.Contents c=p.new Contents();
        Parcel3.Destination d=p.new Destination("Tasmania");
    }
}
