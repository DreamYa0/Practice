package codecomplete;

import java.util.Scanner;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/10.
 *         P37
 */
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        long number = scan.nextLong();
        System.out.println("你输入的数字是：" + number);
        System.out.println("该数乘以2的结果为：" + (number << 1));
        System.out.println("该数乘以4的结果为：" + (number << 2));
        System.out.println("该数乘以8的结果为：" + (number << 3));
        System.out.println("该数乘以16的结果为：" + (number << 4));
    }
}
