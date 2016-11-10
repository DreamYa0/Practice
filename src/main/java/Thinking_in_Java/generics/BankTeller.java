package Thinking_in_Java.generics;

import Thinking_in_Java.net.mindview.util.Generator;

import java.util.*;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/17.
 *         P370 匿名内部类
 */
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}

class Customer {
    private static long counter = 1;
    private static long id = counter++;

    private Customer() {
    }

    public String toString() {
        return "Customer " + id;
    }

    //匿名内部类
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private static long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
