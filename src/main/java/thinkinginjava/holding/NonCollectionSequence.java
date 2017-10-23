package thinkinginjava.holding;

import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pets;

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
