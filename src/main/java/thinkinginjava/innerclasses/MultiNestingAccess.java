package thinkinginjava.innerclasses;

/**
 * Created by DreamYao on 2016/6/16.
 * P203从多层嵌套类中访问外部类的成员
 * 嵌套类中可以访问外围类的私有成员
 */
public class MultiNestingAccess {
    public static void main(String[] args){
        MNA mna=new MNA();
        MNA.A mnaa=mna.new A();
        MNA.A.B mnaab=mnaa.new B();
    }
}
class MNA{
    private void f(){}
    class A{
        private void g(){}
        public class B{
            void h(){
                f();
                g();
            }
        }
    }
}