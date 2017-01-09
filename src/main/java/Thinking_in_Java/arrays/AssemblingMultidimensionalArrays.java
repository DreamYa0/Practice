package Thinking_in_Java.arrays;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/9.
 * P439 多维数组
 */
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
