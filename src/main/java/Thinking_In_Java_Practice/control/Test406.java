package Thinking_In_Java_Practice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test406 {
    static void test(int testval,int target){
        if (testval>target) {
            System.out.println(testval+">"+target);
        }else if (testval<target) {
            System.out.println(testval+"<"+target);
        }else {
            System.out.println(testval+"="+target);
        }
    }
    static void test(int begin,int testval,int end){
        if (begin<testval&&testval<end) {
            System.out.println(begin+"<"+testval+"<"+end);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        test(10, 20);
        test(1, 10, 30);

    }

}
