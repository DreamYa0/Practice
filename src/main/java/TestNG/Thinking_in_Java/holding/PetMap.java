package TestNG.Thinking_in_Java.holding;

import TestNG.Thinking_in_Java.typeinfo.pets.Cat;
import TestNG.Thinking_in_Java.typeinfo.pets.Dog;
import TestNG.Thinking_in_Java.typeinfo.pets.Hamster;
import TestNG.Thinking_in_Java.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DreamYao on 2016/7/7.
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("my Cat", new Cat("Molly"));
        petMap.put("my Dog", new Dog("Ginger"));
        petMap.put("my Hamster", new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("my Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("my Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
