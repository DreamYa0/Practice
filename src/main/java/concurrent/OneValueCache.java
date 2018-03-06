package concurrent;

import org.bouncycastle.util.Arrays;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;

/**
 * @author dreamyao
 * @title 对结果进行缓存的不可变容器
 * @date 2018/3/2 下午2:06
 * @since 1.0.0
 */
@Immutable
public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getfactors(BigInteger i){
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
