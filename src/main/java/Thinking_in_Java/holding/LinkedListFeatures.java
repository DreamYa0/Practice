package Thinking_in_Java.holding;

import Thinking_in_Java.typeinfo.pets.Pet;
import Thinking_in_Java.typeinfo.pets.Pets;

import java.util.LinkedList;

/**
 * Created by DreamYao on 2016/7/1.
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        System.out.println(pets);
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element: " + pets.element());
    }
}
