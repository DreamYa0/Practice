package Thinking_In_Java_Practice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test521 {

    public enum monery {
        LIN,BIG,BIGBG,LL,BB,BIBB
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(monery a:monery.values()){
            System.out.println(a);
        }
    }
}
