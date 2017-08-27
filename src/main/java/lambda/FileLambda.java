package lambda;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.stream.Collectors;

import static lambda.FilterApple.filterApples;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/20 20:40
 */
public class FileLambda {

    public static void main(String[] args) {
        //正确情况的表达式
        File[] hiddFiles=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        //Lambda表达式
        File[] hiddenFiles=new File(".").listFiles(File::isHidden);
        List<Apple> apples = Lists.newArrayList();
        List<Apple> greenResult = filterApples(apples, Apple::isHeavyApple);
        List<Apple> greenResult1 = filterApples(apples, (Apple apple) -> apple.getWeight() > 150);
        List<Apple> heavyResult = filterApples(apples, Apple::isGreenApple);
        List<Apple> heavyResult2 = filterApples(apples, (Apple apple)->"green".equals(apple.getColor()));
        List<Apple> heavyResult3 = apples.stream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
    }
}
