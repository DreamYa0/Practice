package Thinking_in_Java.generics;

import Thinking_in_Java.net.mindview.util.New;
import Thinking_in_Java.typeinfo.Person;
import Thinking_in_Java.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-2.
 *         P363
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
