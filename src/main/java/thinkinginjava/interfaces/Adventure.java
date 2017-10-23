package thinkinginjava.interfaces;

/**
 * Created by DreamYao on 2016/5/19.
 * P179 Java中的多重继承.
 */
public class Adventure {
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
class Hero extends ActionCharacter implements CanFight,CanFly,CanSwim{
    public void fly() {}
    public void swin() {}
}
