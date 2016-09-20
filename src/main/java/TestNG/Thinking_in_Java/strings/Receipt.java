package TestNG.Thinking_in_Java.strings;

        import java.util.Formatter;

/**
 * Created by DreamYao on 2016/8/1.
 * 格式化说明符
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "----", "----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2s\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2s\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2s\n", "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Beans Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
