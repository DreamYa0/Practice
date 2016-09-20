package TestNG.Thinking_in_Java.holding;

import TestNG.Thinking_in_Java.typeinfo.pets.Pet;
import TestNG.Thinking_in_Java.typeinfo.pets.Pets;

import java.util.Iterator;

/**
 * Created by DreamYao on 2016/7/10.
 * P241
 */
public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}
