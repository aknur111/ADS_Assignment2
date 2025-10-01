package insertionsort;

public final class InsertionSort {

    private InsertionSort() {}

    public static void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("mustnt be null");
        int n = arr.length;
        if (n < 2) return;

        int minIdx = 0;
        for (int i = 1; i < n; i++) if (arr[i] < arr[minIdx]) minIdx = i;
        swap(arr, 0, minIdx);

        for (int i = 2; i < n; i++) {
            int key = arr[i];
            if (key >= arr[i - 1]) continue;
            int pos = binarySearch(arr, key, 1, i - 1);
            System.arraycopy(arr, pos, arr, pos + 1, i - pos);
            arr[pos] = key;
        }
    }

    private static int binarySearch(int[] a, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (a[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}