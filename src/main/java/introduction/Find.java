package introduction;

/**
 * Created by DreamYao on 2016/5/19.
 */
//顺序查找
public class Find {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object b=Find.MethodBody(new int[]{31, 41, 59, 26, 41, 58}, 2);
        System.out.println("查找到的位置 :"+b );

    }
    public static final Object MethodBody(int A[],int u) {
        for (int i = 0; i < A.length; i++) {
            if (A[i]==u) {
                return i;
            }
        }
        return " 没有找到";
    }

}
