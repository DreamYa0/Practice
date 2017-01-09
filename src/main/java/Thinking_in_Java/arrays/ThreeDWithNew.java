package Thinking_in_Java.arrays;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/9.
 * P438 多维数组
 */
public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
}
