package TestNG.Data_Structures_And_Analysis;

/**
 * Created by DreamYao on 2016/7/23.
 */
public class WrapperDemo {
    public static void main(String[] args) {
        MemoryCell m = new MemoryCell();
        m.write("37");
        Integer wrapperVal = (Integer) m.read();
        int val = wrapperVal.intValue();
        System.out.println("Contents are: " + val);
    }
}
