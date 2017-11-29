package thinkinginjavapractice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test404 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= (int) Math.sqrt(i) + 1; j++) {// 把Math.sqrt(i)转换为int类形
                if (i == 2 && j == 2) {
                    System.out.println(j + " is a prime");
                    continue;
                }
                if (i % j == 0) {
                    break;
                }
                if (j >= (int) Math.sqrt(i) + 1) {
                    System.out.println(i + " is a prime");
                }
            }
        }
    }
}
