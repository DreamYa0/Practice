package Data_Structures_And_Analysis;

/**
 * @author dreamyao
 * Created by dreamyao on 2017/3/23.
 * 累加算法
 */
public class MaxSubSum {

    public static int maxSubSum(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(maxSubSum(array));
    }
}
