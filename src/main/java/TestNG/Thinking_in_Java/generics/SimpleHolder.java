package TestNG.Thinking_in_Java.generics;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/24.
 *         P379
 */
public class SimpleHolder {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        SimpleHolder simpleHolder = new SimpleHolder();
        simpleHolder.setObj("Item");
        String s = (String) simpleHolder.getObj();
        System.out.println(s);
    }
}
