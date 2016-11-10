package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P142空白final,必须在定义处或者构造器中被初始化
public class BlankFinal {
    @SuppressWarnings("unused")
    private final int i=0;
    @SuppressWarnings("unused")
    private final int j;
    @SuppressWarnings("unused")
    private final Poppet p;
    public BlankFinal() {
        j=1;
        p=new Poppet(1);
    }
    public BlankFinal(int x) {
        j=x;
        p=new Poppet(x);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BlankFinal();
        new BlankFinal(47);
    }
}

class Poppet {
    @SuppressWarnings("unused")
    private int i;
    Poppet(int ii) {
        // TODO Auto-generated constructor stub
        i = ii;
    }
}
