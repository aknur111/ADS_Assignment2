package selectionsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void handlesEmptyAndSingle() {
        int[] a = {};
        SelectionSort.sort(a);
        assertArrayEquals(new int[]{}, a);

        int[] b = {7};
        SelectionSort.sort(b);
        assertArrayEquals(new int[]{7}, b);
    }

    @Test
    void sortsSimpleCases() {
        int[] a = {3, 1, 2};
        SelectionSort.sort(a);
        assertArrayEquals(new int[]{1, 2, 3}, a);

        int[] b = {5, 5, 5, 5};
        SelectionSort.sort(b);
        assertArrayEquals(new int[]{5, 5, 5, 5}, b);

        int[] c = {2, 1};
        SelectionSort.sort(c);
        assertArrayEquals(new int[]{1, 2}, c);
    }

    @Test
    void sortsNegativeAndMixed() {
        int[] a = {0, -1, 3, -2, 2};
        SelectionSort.sort(a);
        assertArrayEquals(new int[]{-2, -1, 0, 2, 3}, a);
    }

    @Test
    void matchesJavaSort_randomized() {
        Random rnd = new Random(123);
        for (int t = 0; t < 200; t++) {
            int n = rnd.nextInt(50);
            int[] a = rnd.ints(n, -1000, 1001).toArray();
            int[] b = a.clone();

            SelectionSort.sort(a);
            Arrays.sort(b);

            assertArrayEquals(b, a);
        }
    }
}

