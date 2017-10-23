package thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dreamyao
 *         Created by dreamyao on 2017/2/13.
 *         P441 范型与数组
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<>();
        Object[] objects = ls;
        objects[1] = new ArrayList<>();
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
