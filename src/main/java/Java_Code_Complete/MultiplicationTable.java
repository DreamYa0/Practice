package Java_Code_Complete;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/12.
 *         P45
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
