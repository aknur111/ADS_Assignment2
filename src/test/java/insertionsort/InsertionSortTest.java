package insertionsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void handlesEmptyAndSingle() {
        int[] empty = {};
        InsertionSort.sort(empty);
        assertArrayEquals(new int[]{}, empty);

        int[] single = {42};
        InsertionSort.sort(single);
        assertArrayEquals(new int[]{42}, single);
    }

    @Test
    void sortsTypicalCases() {
        int[] a = {3, 1, 2};
        InsertionSort.sort(a);
        assertArrayEquals(new int[]{1, 2, 3}, a);

        int[] b = {5, 5, 5};
        InsertionSort.sort(b);
        assertArrayEquals(new int[]{5, 5, 5}, b);

        int[] c = {0, -1, 4, -2, 2};
        InsertionSort.sort(c);
        assertArrayEquals(new int[]{-2, -1, 0, 2, 4}, c);
    }

    @Test
    void inPlace_noArrayReferenceChange() {
        int[] a = {4, 3, 2, 1};
        int[] sameRef = a;
        InsertionSort.sort(a);
        assertSame(sameRef, a);
        assertArrayEquals(new int[]{1, 2, 3, 4}, a);
    }

    @Test
    void matchesJavaSort_randomized() {
        Random rnd = new Random(321);
        for (int t = 0; t < 200; t++) {
            int n = rnd.nextInt(200);
            int[] test = rnd.ints(n, -10_000, 10_001)
                    .toArray();
            int[] expected = test.clone();

            InsertionSort.sort(test);
            Arrays.sort(expected);

            assertArrayEquals(expected, test);
        }
    }
}