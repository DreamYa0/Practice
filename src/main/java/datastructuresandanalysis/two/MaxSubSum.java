package datastructuresandanalysis.two;

/**
 * @author dreamyao
 * @description 最大子序列求和
 * @date 2017/12/7 下午7:58
 * @since 1.0.0
 */
public class MaxSubSum {

    public static int maxSubSumOne(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k < j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSumTwo(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = 0; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubThree(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            return a[left] > 0 ? a[left] : 0;
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center, right);
        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int sum) {
        return 0;
    }

    public static int maxSubSumFour(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
