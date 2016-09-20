package TestNG.Thinking_in_Java.holding;

        import TestNG.Thinking_in_Java.typeinfo.pets.Pet;
        import TestNG.Thinking_in_Java.typeinfo.pets.Pets;

        import java.util.*;

/**
 * Created by DreamYao on 2016/7/1.
 */
public class CrossContainerIteration {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }

}
