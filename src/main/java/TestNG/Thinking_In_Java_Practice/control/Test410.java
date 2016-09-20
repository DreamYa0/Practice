package TestNG.Thinking_In_Java_Practice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Arrays;

public class Test410 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] ar_str1, ar_str2;
        int sum = 0;
        int from;
        int to;
        int i_val;
        int count = 0;
        // 双重循环穷举
        for (int i = 10; i < 100; i++) {
            // j=i+1避免重复
            from = Math.max(1000 / i, i + 1);
            to = Math.min(10000 / i, 100);
            for (int j = from; j < to; j++) {
                i_val = i * j;
                if (i_val % 100 == 0 || (i_val - i - j) % 9 != 0) {
                    continue;
                }
                count++;
                ar_str1 = String.valueOf(i_val).split("");
                ar_str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(ar_str1);
                Arrays.sort(ar_str2);
                if (Arrays.equals(ar_str1, ar_str2)) {// 排序后比较,为真则找到一组
                    sum++;
                    System.out.println("第" + sum + "组: " + i + "*" + j + "=" + i_val);
                }
            }
        }
        System.out.println("共找到" + sum + "组吸血鬼数");
        System.out.println(count);
    }
}

