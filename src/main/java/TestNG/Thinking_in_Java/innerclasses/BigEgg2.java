package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 * P213导出类的内部类，继承基类中的内部类，是可以覆盖基类的内部类
 */
public class BigEgg2 extends Egg2{
    public class Yolk extends Egg2.Yolk{
        public Yolk(){
            System.out.println("BigEgg2.Yolk()");
        }
        public void f(){
            System.out.println("BigEgg2.Yolk.f()");
        }
    }
    public BigEgg2(){
        insertYolk(new Yolk());
    }
    public static void main(String[] args){
        Egg2 e2=new BigEgg2();
        e2.g();
    }
}
class Egg2{
    protected class Yolk{
        public Yolk(){
            System.out.println("Egg2.Yolk()");
        }
        public void f(){
            System.out.println("Egg2.Yolk.f()");
        }
    }
    private Yolk y=new Yolk();
    public Egg2(){System.out.println("New Egg2()");}
    public void insertYolk(Yolk yy){
        y=yy;
    }
    public void g(){y.f();}
}