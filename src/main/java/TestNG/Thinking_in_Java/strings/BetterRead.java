package TestNG.Thinking_in_Java.strings;

import java.util.Scanner;

/**
 * Created by DreamYao on 2016/8/24.
 * P310 Scanner类
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name?");
        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you? What is your favorite double?");
        System.out.println("(input:<age> <Double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.println(age);
        System.out.println(favorite);
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 year you will be %d.\n", age + 5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}
