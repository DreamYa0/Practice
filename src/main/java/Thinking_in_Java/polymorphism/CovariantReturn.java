package Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P164协变返回类型
public class CovariantReturn {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Mill mill=new Mill();
        Grain grain=mill.process();
        System.out.println(grain);
        mill=new WheatMill();
        grain=mill.process();
        System.out.println(grain);

    }

}
class Grain{
    public String toString(){
        return "Grain";
    }
}
class Wheat extends Grain{
    public String toString(){
        return "Wheat";
    }
}
class Mill{
    Grain process(){
        return new Grain();
    }
}
class WheatMill extends Mill{
    Wheat process(){
        return new Wheat();
    }
}
