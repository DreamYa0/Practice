package thinkinginjava.exceptions;

/**
 * Created by DreamYao on 2016/7/29.
 * P275 异常匹配
 */
public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}