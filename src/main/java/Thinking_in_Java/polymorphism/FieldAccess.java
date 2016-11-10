package Thinking_in_Java.polymorphism;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class FieldAccess {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Super sup = new Sub();
        System.out.println("sup.field=" + sup.field + ",sup.getField()=" + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field=" + sub.field + ",sup.getfield()=" + sub.getField() + ",sub.getSuperField()="
                + sub.getSuperField());

    }

}

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}
