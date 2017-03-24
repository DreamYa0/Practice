package Data_Structures_And_Analysis;

/**
 * Created by dreamyao on 2017/3/23.
 * 二分搜索
 */
public class BinarySeach {

    private static final int NOT_FOUND = -1;

    public static <AnyType extends Comparable<? super AnyType>> int binarySeach(AnyType[] anyTypes, AnyType x) {
        int low = 0, high = anyTypes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (anyTypes[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (anyTypes[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }
}
