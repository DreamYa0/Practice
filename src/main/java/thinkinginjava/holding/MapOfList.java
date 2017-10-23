package thinkinginjava.holding;

import thinkinginjava.typeinfo.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DreamYao on 2016/7/7.
 * P234 Map嵌套List打印
 */
public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(
                new Pug("Louie ake Louis Snorkelstein Dupree"),
                new Cat("Stanford ake Stinky el Negro"),
                new Cat("Pinkola")
        ));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaa"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        //打印Map嵌套List
        for (Person person : petPeople.keySet()) {
            System.out.println(person + "  has: ");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("   " + pet);
            }
        }
        System.out.println(petPeople);
    }
}
