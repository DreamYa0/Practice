package concurrent;

import java.math.BigInteger;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午4:15
 * @since 1.0.0
 */
public class ExpensiveFuntion implements Computable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 经过很长的计算
        return new BigInteger(arg);
    }
}
