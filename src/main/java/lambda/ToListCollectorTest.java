package lambda;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/19 21:47
 */
public class ToListCollectorTest {

    public static void main(String[] args) {

    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n){
        // return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
        return null;
    }

    public static boolean isPrime(List<Integer> primes,int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> predicate) {
        int i = 0;
        for (A item : list) {
            if (!predicate.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}