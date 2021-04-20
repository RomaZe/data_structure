package heap;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    boolean readyToRead = false;
    boolean readyToExit = false;
    static int count = 1;

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    synchronized void put() throws InterruptedException {
        while (readyToRead)
//            System.out.println("Producer wait");
            wait();

        try {
            for (int i = 1; i <= 30; i++) {
                heap.insert(count);
                count++;
            }

            System.out.println(Thread.currentThread().getName() + ": Put data:" + heap);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            readyToExit = true;
        }

        readyToRead = true;
        notify();
    }

    synchronized public void get() throws InterruptedException {
        while (!readyToRead)
//            System.out.println("Consumer wait");
            wait();

        if (!readyToExit) {
            int maxElement = heap.delete();
            System.out.println(Thread.currentThread().getName() + ": Get Max element: " + maxElement);
            readyToRead = false;
            notify();
        }
    }

}
