package Data_Structures_And_Analysis;

/**
 * Created by DreamYao on 2016/6/26.
 */
public class FindMaxDemo {
    /**
     * Return max item arr.
     * Precondition: arr.length>0
     */
    public static Comparable findMax(Comparable[] arr){
        int maxIndex=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i].compareTo(arr[maxIndex])>0);
            maxIndex=i;
        }
        return arr[maxIndex];
    }
    /**
     * Test findMax on Shape and String objects.
     */
    public static void main(String[] args) {
    }
}
