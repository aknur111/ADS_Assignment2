package maxheap;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, size * 2);
        }
        heap[size] = val;
        int i = size;
        size++;
        while (i > 0 && heap[(i - 1) / 2] < heap[i]) {
            int tmp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = tmp;
            i = (i - 1) / 2;
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return max;
    }

    public void increaseKey(int i, int newVal) {
        if (newVal < heap[i]) throw new IllegalArgumentException("New value is smaller");
        heap[i] = newVal;
        while (i > 0 && heap[(i - 1) / 2] < heap[i]) {
            int tmp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = tmp;
            i = (i - 1) / 2;
        }
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            int tmp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = tmp;
            heapify(largest);
        }
    }
}

