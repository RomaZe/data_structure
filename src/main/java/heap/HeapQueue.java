package heap;

public class HeapQueue {
    HeapMaxArray heap;
    int maxHeapSize;
    boolean runnable = true;
    static int count = 1;

    public HeapQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        heap = new HeapMaxArray(maxHeapSize);
    }

    void put() throws InterruptedException {
        try {
            for (int i = 1; i <= maxHeapSize; i++) {
                heap.insert(count);
                Thread.sleep(100);
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add more than " + maxHeapSize + " tuples into Heap Array.");
            runnable = false;
        }
    }

    public void get() throws InterruptedException {
        if (runnable) {
            int maxElement = heap.delete();
            System.out.println("Get Max element: " + maxElement);
        }
    }
}
