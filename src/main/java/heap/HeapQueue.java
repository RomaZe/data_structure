package heap;

import java.util.TreeMap;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    boolean readyToRead = false;
    boolean readytoExit = false;
    static int count = 1;

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    synchronized void put() throws InterruptedException {
        while (readyToRead)
            wait();

        try {
            for (int i = 1; i <= 30; i++) {
                heap.insert(count);
                count++;
            }

            System.out.println("Put data:" + heap);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            readytoExit = true;
        }

        readyToRead = true;
        notify();
    }

    synchronized public void get() throws InterruptedException {
        while (!readyToRead)
            wait();

        if (!readytoExit) {
            int maxElement = heap.delete();
            System.out.println("Get Max element: " + maxElement);
            readyToRead = false;
            notify();
        }
    }
}
