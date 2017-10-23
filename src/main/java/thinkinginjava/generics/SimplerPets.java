package thinkinginjava.generics;

import thinkinginjava.net.mindview.util.New;
import thinkinginjava.typeinfo.Person;
import thinkinginjava.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-2.
 *         P362
 */
public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
    }
}
