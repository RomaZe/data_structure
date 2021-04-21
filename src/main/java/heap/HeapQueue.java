package heap;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    AtomicBoolean mutexAtomic = new AtomicBoolean(true);
    boolean readyToExit = false;
    static int count = 1;

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    void put() throws InterruptedException {
        try {
            for (int i = 1; i <= 10; i++) {
                heap.insert(count);
                count++;
            }

            System.out.println(Thread.currentThread().getName() + ": Put data:" + heap);
//            System.out.println(Thread.currentThread().getName() + ": Put data into Heap.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            readyToExit = true;
        }
    }

    public void get() throws InterruptedException {
        try {
            if (!readyToExit) {
                int maxElement = heap.delete();
                System.out.println(Thread.currentThread().getName() + ": Get Max element: " + maxElement);
            } else {
                System.out.println("Array is full. get do nothing.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Cannot take max element from heap. Heap is empty.");

        }

    }

}
