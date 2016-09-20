package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/21.
 * P212内部类的继承
 */
public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super();
    }
    public static void main(String[] args){
        WithInner wi=new WithInner();
        InheritInner ii=new InheritInner(wi);
    }
}
class WithInner{
    class Inner{}
}
