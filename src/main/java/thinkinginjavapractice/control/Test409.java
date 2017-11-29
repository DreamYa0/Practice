package thinkinginjavapractice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test409 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Fibonacci(10);
    }
    public static int Fibonacci(int a) {
        int arr[] = new int[a];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0)
                System.out.println();
            System.out.print(arr[i]+"\t"); }
        return a;
    }
}

