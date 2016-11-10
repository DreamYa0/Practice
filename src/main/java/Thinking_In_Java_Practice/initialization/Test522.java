package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test522 {
    monery my;
    public enum monery {
        LIN,BIG,BIGBG,LL,BB,BIBB
    }
    public Test522(monery my) {
        // TODO Auto-generated constructor stub
        this.my=my;
    }
    public void name() {
        switch (my) {
            case LIN:System.out.println("Lin");
                break;
            case BIG:System.out.println("Bin");
                break;
            case LL:System.out.println("Ll");
                break;

            default:System.out.println("lallal");
                break;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Test522 test522=new Test522(monery.BIGBG);
        test522.name();

    }

}

