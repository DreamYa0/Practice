package Data_Structures_And_Analysis;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title 选择问题 P19 NO1
 * @Date 2017/7/13 21:54
 */
public class SelectProblem {

    private static final Random RANDOM = new Random(47);

    /**
     * 生成随机数组
     * @param length 长度
     * @return
     */
    private static int[] createArray(int length) {
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = RANDOM.nextInt(length * 2);
        }
        return values;
    }

    private static int select(int[] values) {
        if (values==null || values.length == 0) {
            throw new NullPointerException("数组不能为空！");
        }
        int k = values.length / 2;
        int[] temp = Arrays.copyOf(values, k);
        sort(temp);
        for (int i = k ; i < values.length; i++) {
            if (values[i] < temp[k - 1]) {
                temp[k - 1] = temp[k - 2];
                for (int j = k - 2; j >0; j--) {
                    if (values[i] > temp[j]) {
                        temp[j + 1] = values[i];
                        break;
                    }else {
                        temp[j] = temp[j - 1];
                    }
                }
            }
        }
        return temp[k - 1];
    }

    /**
     * 冒泡排序
     * @param temp
     */
    private static void sort(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    temp[j] = temp[j] ^ temp[j + 1];
                    temp[j + 1] = temp[j] ^ temp[j + 1];
                    temp[j] = temp[j] ^ temp[j + 1];
                }
            }
        }
    }

    //打印结果
    private static void printResult(int[] values){
        System.out.println("length:" + values.length);
        long start = System.currentTimeMillis();
        System.out.println("result:" + select(values));
        System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("--------------------------------");
    }

    //假设N = 10
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printResult(createArray(RANDOM.nextInt(100000)));
        }
    }
}
