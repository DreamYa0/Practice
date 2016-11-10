package Thinking_in_Java.typeinfo;

import Thinking_in_Java.typeinfo.pets.Pet;

import java.util.LinkedHashMap;

/**
 * Created by DreamYao on 2016/9/9.
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter(){
            super();
        }
    }
}
