package maxheap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void insertAndExtractOrder() {
        MaxHeap heap = new MaxHeap(4);
        heap.insert(3);
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);

        assertEquals(10, heap.extractMax());
        assertEquals(7, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(3, heap.extractMax());
    }

    @Test
    void increaseKeyBubblesUp() {
        MaxHeap heap = new MaxHeap(4);
        heap.insert(4);
        heap.insert(6);
        heap.insert(2);
        heap.insert(5);
        heap.increaseKey(2, 100);
        assertEquals(100, heap.extractMax());
        assertEquals(6, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(4, heap.extractMax());
    }

    @Test
    void increaseKeyRejectsSmallerValue() {
        MaxHeap heap = new MaxHeap(2);
        heap.insert(5);
        heap.insert(8);
        assertThrows(IllegalArgumentException.class, () -> heap.increaseKey(1, 1));
    }

    @Test
    void extractFromEmptyFails() {
        MaxHeap heap = new MaxHeap(1);
        assertThrows(IllegalStateException.class, heap::extractMax);
    }

    @Test
    void capacityGrowsAutomatically() {
        MaxHeap heap = new MaxHeap(1);
        for (int v : new int[]{1, 3, 2, 10, 4, 8}) {
            heap.insert(v);
        }
        assertEquals(10, heap.extractMax());
        assertEquals(8, heap.extractMax());
        assertEquals(4, heap.extractMax());
        assertEquals(3, heap.extractMax());
        assertEquals(2, heap.extractMax());
        assertEquals(1, heap.extractMax());
    }
}

