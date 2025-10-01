package selectionsort;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sortsSimpleArray_andTracksMetrics() {
        int[] arr = {3, 1, 2};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);

        assertArrayEquals(new int[]{1, 2, 3}, arr);
        assertTrue(tracker.getComparisons() > 0, "Should record comparisons");
        assertTrue(tracker.getSwaps() > 0, "Should record at least one swap");
        assertTrue(tracker.getArrayAccesses() > 0, "Should record array accesses");
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);

        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
        assertEquals(0, tracker.getSwaps(), "No swaps expected for sorted input");
    }

    @Test
    void handlesEmptyAndSingleElement() {
        int[] empty = {};
        PerformanceTracker t1 = new PerformanceTracker();
        SelectionSort.sort(empty, t1);
        assertArrayEquals(new int[]{}, empty);
        assertEquals(0, t1.getComparisons());
        assertEquals(0, t1.getSwaps());
        assertEquals(0, t1.getArrayAccesses());

        int[] single = {7};
        PerformanceTracker t2 = new PerformanceTracker();
        SelectionSort.sort(single, t2);
        assertArrayEquals(new int[]{7}, single);
        assertEquals(0, t2.getSwaps());
    }

    @Test
    void handlesDuplicatesAndNegatives() {
        int[] arr = {0, -1, 5, -2, 5};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);

        assertArrayEquals(new int[]{-2, -1, 0, 5, 5}, arr);
    }
}

