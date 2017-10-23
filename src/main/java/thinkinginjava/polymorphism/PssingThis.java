package thinkinginjava.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class PssingThis {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Person().eat(new Apple());

    }

}

class Person {
    public void eat(Apple apple) {

        System.out.println("Yummy");

    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}
