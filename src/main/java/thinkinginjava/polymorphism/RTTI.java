package thinkinginjava.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P167向下转型与运行时类型识别
public class RTTI {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Useful[] x={new Useful(),new MoreUseful()};
        x[0].f();
        x[1].g();
        ((MoreUseful)x[1]).u();//向下转型
        ((MoreUseful)x[0]).u();

    }

}
class Useful{
    public void f(){}
    public void g(){}
}
class MoreUseful extends Useful{
    public void f(){}
    public void g(){}
    public void u(){}
    public void v(){}
    public void m(){}
}
