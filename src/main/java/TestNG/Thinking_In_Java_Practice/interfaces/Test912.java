package TestNG.Thinking_In_Java_Practice.interfaces;

/**
 * Created by DreamYao on 2016/5/21.P179
 */
public class Test912 {
    public static void t(CanFight x){
        x.fight();
    }
    public static void u(CanSwim x){
        x.swin();
    }
    public static void v(CanFly x){
        x.fly();
    }
    public static void w(ActionCharacter x){
        x.fight();
    }
    public static void f(CanClimb x){
        x.can();
    }
    public static void e(ActionCharacter[] a){
        for (ActionCharacter b:a) {
            b.fight();
        }
    }
    public static void main(String[] args){
        Hero hero=new Hero();
        t(hero);//向上转型为接口
        v(hero);
        u(hero);
        w(hero);
        f(hero);
        ActionCharacter[] f={new Hero()};
        e(f);//向上转型为基类对象
    }
}
interface CanFight{
    void fight();
}
interface CanSwim{
    void swin();
}
interface CanFly{
    void fly();
}
class ActionCharacter{
    public void fight(){}
}
class Hero extends ActionCharacter implements CanFight,CanFly,CanSwim,CanClimb{
    public void fly() {}
    public void swin() {}

    @Override
    public void can() {

    }
}
interface CanClimb{
    void can();
}