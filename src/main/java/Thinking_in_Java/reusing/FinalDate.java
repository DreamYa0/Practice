package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P140final7关键字
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Random;

public class FinalDate {
    private static Random rand=new Random(47);
    private String id;
    public FinalDate(String id) {
        this.id=id;
    }
    @SuppressWarnings("unused")
    private final int valueOne=9;
    @SuppressWarnings("unused")
    private static final int VALUE_TWO=99;
    @SuppressWarnings("unused")
    private static final int VALUE_THREE=39;
    private final int i4=rand.nextInt(20);
    private final int INT_5=rand.nextInt(20);
    @SuppressWarnings("unused")
    private Value v1=new Value() {

        @Override
        public int getSize() {
            // TODO Auto-generated method stub
            return 11;
        }
    };
    @SuppressWarnings("unused")
    private final Value v2=new Value() {

        @Override
        public int getSize() {
            // TODO Auto-generated method stub
            return 22;
        }
    };
    @SuppressWarnings("unused")
    private static final Value v3=new Value() {

        @Override
        public int getSize() {
            // TODO Auto-generated method stub
            return 33;
        }
    };
    private final int[] a={1,2,3,4,5,6};
    public String toString() {
        return id+ ": "+"i4= "+i4+ ", INT_5= "+INT_5;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FinalDate fd1 =new FinalDate("fdl");
//		fd1.v2.i++;
        fd1.v1=new Value() {

            @Override
            public int getSize() {
                // TODO Auto-generated method stub
                return 9;
            }
        };
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        System.out.println(fd1);
        System.out.println("Creating new FinalDate");
        FinalDate fd2=new FinalDate("fd2");
        System.out.println(fd1);
        System.out.println(fd2);

    }

}
