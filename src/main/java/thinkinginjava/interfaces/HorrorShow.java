package thinkinginjava.interfaces;

/**
 * Created by DreamYao on 2016/5/21.P180通过继承来扩展接口
 */
public class HorrorShow {
    static void u(Monster b){
        b.menace();
    }
    static void v(DangerousMoster d){
        d.destroy();
        d.menace();
    }
    static void w(Lethal l){
        l.kill();
    }
    static void h(Vampire v){
        v.drinkBlood();
    }
    public static void main(String[] args){
        DangerousMoster barney=new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad=new VerBadVampire();
        v(vlad);
        u(vlad);
        w(vlad);
        h(vlad);
    }
}
interface Monster{
    void menace();
}
interface DangerousMoster extends Monster{
    void destroy();
}
interface Lethal{
    void kill();
}
class DragonZilla implements DangerousMoster{
    public void menace(){}
    public void destroy(){}
}
interface Vampire extends DangerousMoster,Lethal{
    void drinkBlood();
}
class VerBadVampire implements Vampire{
    public void menace(){}
    public void destroy(){}
    public void kill(){}
    public void drinkBlood(){}
}
