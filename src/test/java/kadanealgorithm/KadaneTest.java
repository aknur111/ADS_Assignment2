package kadanealgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KadaneTest {

    @Test
    void handlesSingleAndAllNegative() {
        int[] a1 = {-5};
        int[] r1 = Kadane.maxSubarray(a1);
        assertArrayEquals(new int[]{-5, 0, 0}, r1);

        int[] a2 = {-8, -3, -6, -2, -5, -4};
        int[] r2 = Kadane.maxSubarray(a2);
        assertArrayEquals(new int[]{-2, 3, 3}, r2);
    }

    @Test
    void typicalExamples() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] r = Kadane.maxSubarray(a);
        assertArrayEquals(new int[]{6, 3, 6}, r);
    }

    @Test
    void wholeArrayPositive() {
        int[] a = {1, 2, 3, 4};
        int[] r = Kadane.maxSubarray(a);
        assertArrayEquals(new int[]{10, 0, 3}, r);
    }

    @Test
    void zerosAndPositives() {
        int[] a = {0, 0, 5, 0, 0};
        int[] r = Kadane.maxSubarray(a);
        assertArrayEquals(new int[]{5, 2, 2}, r);
    }
}

