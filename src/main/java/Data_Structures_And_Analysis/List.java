package Data_Structures_And_Analysis;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title 顺序表
 * @Date 2017/9/16 17:17
 */
public class List<T> {

    private static final int MAXSIZE = 100;
    private int length;
    private Object[] list = new Object[MAXSIZE + 1];

    public List() {
        length = 0;
    }

    public int size() {
        return length;
    }

    public void insert(T data, int index) {
        if (length >= MAXSIZE) {
            System.out.println("顺序表已满，无法插入数据！");
            return;
        }
        if (index < 1 || index > size() - 1) {
            System.out.println("请输入正确的索引号！");
            return;
        }
        System.arraycopy(list, index + 1, list, index + 1 + 1, size() - index);
        list[index] = data;
        length++;

    }

    public void add(T data) {
        if (length >= MAXSIZE) {
            Object[] newList = list;
            list = new Object[2 * MAXSIZE + 1];
            for (int i = 0; i < newList.length; i++) {
                list[i] = newList[i];
            }
        }
        list[length++] = data;
    }

    public void delete(int index) {
        if (index < 1 || index > size() - 1) {
            System.out.println("请输入正确的索引号！");
            return;
        }
        for (int i = index; i < length; i++) {
            list[i] = list[i + 1];
        }
        length--;
    }

    public T get(int index) {
        return (T) list[index];
    }
}
