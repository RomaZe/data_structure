package heap;

import java.util.concurrent.atomic.AtomicBoolean;

public class HeapQueueAtomic {
    HeapMaxArray heap;
    int maxHeapSize;
    boolean readyToExit = false;
    AtomicBoolean atomicReadyToRead = new AtomicBoolean(false);
    static int count = 1;

    public HeapQueueAtomic(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    void put() throws InterruptedException {

        try {
//            System.out.println("Producer wait...");
//              System.out.println(Thread.currentThread().getName() +", Atomic Variable: " + atomicReadyToRead.get());
            if (atomicReadyToRead.get() == false) {
                for (int i = 1; i <= 30; i++) {
                    heap.insert(count);
                    count++;
                }
                System.out.println("Put data:" + heap);
                atomicReadyToRead.set(true);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            readyToExit = true;

        }
    }

    public void get() throws InterruptedException {
        while (!readyToExit) {
//            System.out.println("Consumer wait...");
//            System.out.println(Thread.currentThread().getName() +", Atomic Variable: " + atomicReadyToRead.get());
            if (atomicReadyToRead.get() == true) {
                int maxElement = heap.delete();
                System.out.println("Get Max element: " + maxElement);
                atomicReadyToRead.set(false);
            }
        }
    }

}
