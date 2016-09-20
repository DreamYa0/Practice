package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/6.P193使用.this与.new
 */
public class DotNew {
    public class Inner{}
    public static void main(String[] args){
        DotNew.Inner dni=new DotNew().new Inner();
    }
}
