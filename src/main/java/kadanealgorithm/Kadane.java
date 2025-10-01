package kadanealgorithm;

public class Kadane {
    public static int[] maxSubarray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < arr.length; i++) {
            if (maxEndingHere <= 0) {
                maxEndingHere = arr[i];
                s = i;
            } else {
                maxEndingHere += arr[i];
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }
        return new int[]{maxSoFar, start, end};
    }
}
