package Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/29.
 * P274
 */
public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup nc1 = new NeedsCleanup();
        try {

        } finally {
            nc1.dispose();
        }
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {

        } finally {
            nc3.dispose();
            nc2.dispose();
        }
        try {
            NeedCleanup2 nc4 = new NeedCleanup2();
            try {
                NeedCleanup2 nc5 = new NeedCleanup2();
                try {

                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedCleanup " + id + "dispose");
    }
}

class ConstructionException extends Exception {
}

class NeedCleanup2 extends NeedsCleanup {
    public NeedCleanup2() throws ConstructionException {
    }
}
