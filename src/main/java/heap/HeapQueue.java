package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    AtomicBoolean mutexAtomic = new AtomicBoolean(true);
    static int count = 1;
    public Dispetcher dispetcher = new Dispetcher();

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    void put() throws InterruptedException {
        try {
            for (int i = 1; i <= 30; i++) {
                heap.insert(count);
                count++;
            }

            System.out.println(Thread.currentThread().getName() + ": Put data:" + heap);
//            System.out.println(Thread.currentThread().getName() + ": Put data into Heap.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");

            dispetcher.removeProducer(() -> {
                dispetcher.producers.remove(Thread.currentThread());
                Thread.currentThread().interrupt();
            });

            dispetcher.removeConsumer(() -> {
                if (dispetcher.producers.size() == 0) {
                    for (Thread consumer : dispetcher.consumers) {
                        consumer.interrupt();
                    }
                }
            });

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
