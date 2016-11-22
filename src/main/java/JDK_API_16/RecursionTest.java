package JDK_API_16;

/**
 * Created by DreamYao on 2016/11/20.
 * 1、递归函数的定义：
 * 答：递归函数即自调用函数，在函数体内直接或间接的调用自己，即函数的嵌套是函数本身。
 *
 * 2、递归方式：递归调用有直接递归和间接递归两种方式
 * 直接递归：在函数中出现调用函数本身
 *
 * 3、为什么要用递归函数？递归函数的缺点是什么？
 * 答：递归的目的是简化程序设计，使程序易读。
 *
 * 4、递归的条件：
 * 答：需有完成任务的语句，需满足递归的要求（减小而不是发散）
 *
 * 5、递归进阶：
 * 示例4：
 * 编程求解：若一头小母牛，从出生起第四个年头开始每年生一头母牛，按次规律，第n年时有多少头母牛？
 *
 * 程序代码：
 * public class Test3 {
 *   public static void main(String args[]) {
 *      int n=10;  //要查看的年数
 *      System.out.println("共有"+cattle(n)+"头小母牛！");
 *   }
 *   public static int cattle(int n){
 *      if(n<=0)
 *         return 0;
 *      if(n<=3)
 *         return 1;
 *      return cattle(n-1)+ cattle(n-3);//此处是递归要好好理解。
 *   }
 * }
 *
 * 规律：此类问题的递归函数为：
 * 如果要求的是从出生起第四个年头，则递归函数为cattle(n-1)+ cattle(n-3)，
 * 如果要求的是从出生起第五个年头，则递归函数为cattle(n-1)+ cattle(n-4)，
 * 依次类推。
 *
 * 示例1：下面代码求斐波那契数列第n项，斐波那契数列第一和第二项是1，
 * 后面每一项是前两项之和，即1、1、2、3、5、8、13　．．．。
 */
public class RecursionTest {
    public static void main(String[] args) {
        int x1;
        int sum = 0;
        int n = 10;
        for (int i = 0; i < n; i++) {
            x1 = func(i);
            sum += x1;
        }
        System.out.println("Sum= " + sum);
    }

    public static int func(int x) {
        if (x > 2) {
            return (func(x - 1) + func(x - 2));
        } else {
            return 1;
        }
    }
}
