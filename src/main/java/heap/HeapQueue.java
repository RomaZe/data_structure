package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    static int count = 1;

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    boolean put() {
        try {
            for (int i = 1; i <= 30; i++) {
                heap.insert(count);
                count++;
            }

            System.out.println(Thread.currentThread().getName() + ": Put data:" + heap);
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            return false;
        }
    }

    public void get() throws InterruptedException {
        try {
            int maxElement = heap.delete();
            System.out.println(Thread.currentThread().getName() + ": Get Max element: " + maxElement);
        } catch (NoSuchElementException e) {
            System.out.println("Cannot take max element from heap. Heap is empty.");

        }

    }


}
