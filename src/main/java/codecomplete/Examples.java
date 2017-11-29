package codecomplete;

import java.math.BigDecimal;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/12.
 *         P46
 */
public class Examples {
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(0.0); //和
        BigDecimal factorial = new BigDecimal(1.0); //阶剩的计算结果
        int i = 1; //循环增量
        while (i <= 20) {
            sum = sum.add(factorial);
            ++i;
            factorial = factorial.multiply(new BigDecimal(1.0 / i));
        }
        System.out.printf("1+1/2!+1/3!....1/20!的计算结果等于：\n%s%n", sum);
    }
}
