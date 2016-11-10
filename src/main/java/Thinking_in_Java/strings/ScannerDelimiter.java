package Thinking_in_Java.strings;

import java.util.Scanner;

/**
 * Created by DreamYao on 2016/8/24.
 * P311 Scanner定界符
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12,42,78,99,42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }
}
