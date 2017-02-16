package introduction;

/**
 * Created by DreamYao on 2016/5/19.
 */
//插入排序
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InsertionSort.MethodBody2(new int[] { 31, 41, 59, 26, 41, 58 });

    }
    //升序排列
    public static final void MethodBody(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
                A[i + 1] = key;
            }
        }
        System.out.println(Arrays.toString(A));
    }
    //降序排列
    public static final void MethodBody1(int[] B) {
        for (int j = 1; j < B.length; j++) {
            int key = B[j];
            int i = j - 1;
            while (i >= 0 && B[i] < key) {
                B[i + 1] = B[i];
                i = i - 1;
                B[i + 1] = key;
            }
        }
        System.out.println(Arrays.toString(B));
    }

    // 冒泡排序
    public static final void MethodBody2(int[] C) {
        for (int i = 0; i < C.length; i++) {
            for (int j = 1; j < C.length-1; j++) {
                if (C[j-1] > C[j]) {
                    C[j] = C[j] ^ C[j - 1];
                    C[j - 1] = C[j - 1] ^ C[j];
                    C[j - 1] = C[j];
                }
            }
        }
        System.out.println(Arrays.toString(C));
    }
}
