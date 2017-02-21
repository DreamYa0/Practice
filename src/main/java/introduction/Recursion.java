package introduction;

/**
 * Created by dreamyao on 2017/2/21.
 */
public class Recursion {

    // 递归算法
    private static int f(int n) {
        if (n == 0) {
            return 0;
        }
        return 2*f(n-1)+n*n;
    }

    public static void main(String[] args) {
        System.out.println(f(20));
    }
}
