package lambda;

import com.google.common.collect.Lists;
import lambdasinaction.chap4.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static lambdasinaction.chap4.Dish.menu;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/20 23:10
 */
public class FilterApples {

    public static void main(String[] args) throws IOException {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());

        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort(comparing(Apple::getWeight));

        Thread thread = new Thread(() -> System.out.println("Hello World"));

        process(() -> System.out.println("Hello World"));

        String result = processFile(BufferedReader::readLine);

        forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);

        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110);

        //同样的Lambda表达式，不同的函数式接口
        Comparator<Apple> c3 = comparing(Apple::getWeight);
        ToIntBiFunction<Apple, Apple> c4 = (Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight());
        //无类型推断
        BiFunction<Apple, Apple, Integer> c5 = (Apple apple3, Apple apple4) -> apple3.getWeight().compareTo(apple4.getWeight());
        //有类型推断
        BiFunction<Apple, Apple, Integer> c6 = (apple3, apple4) -> apple3.getWeight().compareTo(apple4.getWeight());

        FilterApples filterApples = new FilterApples();
        FilterApples.Trader raoul = filterApples.new Trader("Raoul", "Cambridge");
        FilterApples.Trader mario = filterApples.new Trader("Mario", "Milan");
        FilterApples.Trader alan = filterApples.new Trader("Alan", "Milan");
        FilterApples.Trader brian = filterApples.new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年的所以交易并按交易额排序
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        //交易员都在哪些不同的城市工作过
        List<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());
        Set<String> cities1 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(toSet());

        //查找所有来自于剑桥的交易员，并按字母顺序排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        //返回所有交易员的姓名字符串，按字母顺序排列
        String name = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);//不是很高效

        String name1 = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(joining());//高效

        //有没有交易员在米兰工作
        boolean milaBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);

        //所有交易中，最高的交易额是多少
        Optional<Integer> hightestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);

        //所有交易中，最小的交易
        Optional<Transaction> smallestVlaue = transactions.stream().reduce((s1, s2) -> s1.getValue() < s2.getValue() ? s1 : s2);
        Optional<Transaction> smallestVlaue1 = transactions.stream().min(comparing(Transaction::getValue));

        int calories = menu.stream().mapToInt(Dish::getCalories).sum();

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1);

        IntStream evenNumber = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumber.count());

        Stream<int[]> pythagotenaPriples = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagotenaPriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        //归约
        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> mostCaloresDish = menu.stream().collect(maxBy(dishComparator));

        //汇总
        int tatalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //分组
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        //多级分组
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIEF;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })));

        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        //把收集器转换为另一种类型
        Map<Dish.Type, Dish> mostCaloricByType1 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType, mapping(
                dish -> {
                    if (dish.getCalories() <= 500) {
                        return CaloricLevel.DIEF;
                    } else if (dish.getCalories() <= 800) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }, toCollection(HashSet::new)
        )));

        //分区
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(dish -> dish.getCalories()<500));
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        Map<Boolean, Dish> mostCaloricPatitionByVehetarian = menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    }

    //使用Function<T,R>
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = Lists.newArrayList();
        list.forEach(t -> result.add(function.apply(t)));
        return result;
    }

    //使用Consumer<T>
    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }

    private static void process(Runnable runnable) {
        runnable.run();
    }

    private static String processFile(BufferReaderProcessor processor) throws IOException {
        return "";
    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = Lists.newArrayList();
        inventory.forEach(apple -> {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        inventory.forEach(apple -> {
            String output = formatter.accept(apple);
            System.out.println(output);
        });
    }

    private interface ApplePredicate {
        boolean test(Apple apple);
    }

    private interface Predicate<T> {
        boolean test(T t);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = Lists.newArrayList();
        list.forEach(e -> {
            if (predicate.test(e)) {
                result.add(e);
            }
        });
        return result;
    }


    private static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    private static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    private static class AppleReaAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor()) && apple.getWeight() < 150;
        }
    }

    private interface AppleFormatter {
        String accept(Apple apple);
    }

    private class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A" + characteristic + " " + apple.getColor() + "apple";
        }
    }

    private class AppleSimpleFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }


    private static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple() {

        }

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    public class Trader {
        private final String name;
        private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }

    public enum CaloricLevel {
        DIEF, NORMAL, FAT
    }
}
