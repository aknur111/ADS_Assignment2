package heapsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void handlesEmptyAndSingle() {
        int[] a = {};
        HeapSort.sort(a);
        assertArrayEquals(new int[]{}, a);

        int[] b = {42};
        HeapSort.sort(b);
        assertArrayEquals(new int[]{42}, b);
    }

    @Test
    void sortsTypicalCases() {
        int[] a = {3, 1, 2};
        HeapSort.sort(a);
        assertArrayEquals(new int[]{1, 2, 3}, a);

        int[] b = {5, 5, 5};
        HeapSort.sort(b);
        assertArrayEquals(new int[]{5, 5, 5}, b);

        int[] c = {0, -1, 4, -2, 2};
        HeapSort.sort(c);
        assertArrayEquals(new int[]{-2, -1, 0, 2, 4}, c);
    }

    @Test
    void inPlace_noExtraArrayReferenceChange() {
        int[] a = {4, 3, 2, 1};
        int[] sameRef = a;
        HeapSort.sort(a);
        assertSame(sameRef, a);
        assertArrayEquals(new int[]{1, 2, 3, 4}, a);
    }

    @Test
    void matchesJavaSort_randomized() {
        Random rnd = new Random(321);
        for (int t = 0; t < 200; t++) {
            int n = rnd.nextInt(200);
            int[] a = rnd.ints(n, -10_000, 10_001).toArray();
            int[] b = a.clone();

            HeapSort.sort(a);
            Arrays.sort(b);

            assertArrayEquals(b, a);
        }
    }
}

