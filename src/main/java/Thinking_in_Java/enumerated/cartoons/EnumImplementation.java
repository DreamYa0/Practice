package Thinking_in_Java.enumerated.cartoons;

import Thinking_in_Java.net.mindview.util.Generator;

import java.util.Random;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/5 12:45
 */
public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ",");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter>{

    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}