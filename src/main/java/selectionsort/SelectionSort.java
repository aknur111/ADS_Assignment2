package selectionsort;

import metrics.PerformanceTracker;

public class SelectionSort {
    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            boolean nondecreasing = true;

            for (int j = i + 1; j < n; j++) {
                tracker.incComparisons();
                tracker.incArrayAccesses(2);

                if (arr[j] < arr[minIdx]) minIdx = j;
                if (arr[j] < arr[j - 1]) nondecreasing = false;
            }

            if (nondecreasing) break;
            if (minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                tracker.incSwaps();
                tracker.incArrayAccesses(4);
            }
        }
    }
}
