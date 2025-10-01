import java.util.Arrays;
import insertionsort.InsertionSort;

public class Main {
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};
        var res = InsertionSort.sort(data);
        System.out.println("sorted = " + Arrays.toString(data));
        System.out.println(res);
    }
}