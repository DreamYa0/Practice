package TestNG.Thinking_in_Java.generics;

import TestNG.Thinking_in_Java.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static TestNG.Thinking_in_Java.generics.watercolors.Watercolors.*;
import static TestNG.Thinking_in_Java.net.mindview.util.Sets.*;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/17.
 *         P368 EnumSet的使用方法
 */
public class WatercolorSets {
    public static void main(String[] args) {
        EnumSet<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1,set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("intersection(set1,set2): " + subset);
        System.out.println("difference(set1,subset): " + difference(set1, subset));
        System.out.println("difference(set2,subset): " + difference(set2, subset));
        System.out.println("complement(set1,set2): " + complement(set1, set2));
    }
}
