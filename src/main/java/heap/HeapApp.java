package heap;

import java.util.NoSuchElementException;

public class HeapApp {



    public static void execHeapExamples() {

        // Generate data for Heap
        Integer[] data = {33, 55, 44, 77, 11, 1, 22, 66, 99, 88};
//        Integer[] data = {};
//        Integer[] data = {100};

        Integer newElement = 3;


        // Create Max Heap based on ArrayList<Integer>
        System.out.println("============ Max Heap based on ArrayList ==========================\n");

        HeapMaxArrayList<Integer> heapMaxArrayList = new HeapMaxArrayList<Integer>();

        // Insert data
        for (Integer element : data) {
            heapMaxArrayList.insert(element);
        }

        System.out.println("Heap: " + heapMaxArrayList);
        System.out.println();

        Integer maxElement = heapMaxArrayList.delete();
        System.out.println("Deleted max element: " + maxElement);
        System.out.println("Heap: " + heapMaxArrayList);
        System.out.println();

        heapMaxArrayList.insert(newElement);
        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + heapMaxArrayList);
        System.out.println();


        // Create Max Heap based on Array
        System.out.println("============ Max Heap based on Array =============================\n");

        // Create Max Heap array object with special length
        HeapMaxArray heapMaxArray = new HeapMaxArray(15);

        // Insert data
        for (int element : data) {
            heapMaxArray.insert(element);
        }
        System.out.println("Heap: " + heapMaxArray);
        System.out.println();

        // Delete max elemnt
        int maxHeapMaxElement = heapMaxArray.delete();
        System.out.println("Deleted max element: " + maxHeapMaxElement);
        System.out.println("Heap: " + heapMaxArray);
        System.out.println();

        // Add new element
        heapMaxArray.insert(newElement);
        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + heapMaxArray);
        System.out.println();


        // Create Min Heap based on ArrayList<Integer>
        System.out.println("============ Min Heap based on ArrayList ==========================\n");

        HeapMinArrayList<Integer> heapMinArrayList = new HeapMinArrayList<Integer>();

        // Insert data
        for (Integer element : data) {
            heapMinArrayList.insert(element);
        }

        System.out.println("Heap: " + heapMinArrayList);
        System.out.println();

        Integer minElement = heapMinArrayList.delete();
        System.out.println("Deleted min element: " + minElement);
        System.out.println("Heap: " + heapMinArrayList);
        System.out.println();

        heapMinArrayList.insert(newElement);
        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + heapMinArrayList);
        System.out.println();


        // Create Min Heap based on Array
        System.out.println("============ Min Heap based on Array =============================\n");

        // Create Min Heap array object with special length
        HeapMinArray heapMinArray = new HeapMinArray(15);

        // Insert data
        for (int element : data) {
            heapMinArray.insert(element);
        }
        System.out.println("Heap: " + heapMinArray);
        System.out.println();

        // Delete min element
        int minHeapMinElement = heapMinArray.delete();
        System.out.println("Deleted min element: " + minHeapMinElement);
        System.out.println("Heap: " + heapMinArray);
        System.out.println();

        // Add new element
        heapMinArray.insert(newElement);
        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + heapMinArray);
        System.out.println();

    }

    public static void execHeapExampleThread() throws InterruptedException {

        class Producer implements Runnable {
            Thread worker;
            HeapQueue queue;

            public Producer(HeapQueue queue, String name) {
                this.queue = queue;
                worker = new Thread(this, name);
                System.out.println("Create thread for " + name);
                worker.start();
            }

            public void run() {
                try {
//                    Thread.sleep(3000);
                    while (!queue.readyToExit) {

//                        if (queue.mutex) {
//                            queue.mutex = false;
//                            queue.put();
//                            queue.mutex = true;
//                        }

                        if (queue.mutexAtomic.getAndSet(false)) {
                            queue.put();
                            queue.mutexAtomic.getAndSet(true);
                        }

                       Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class Consumer implements Runnable {
            Thread worker;
            HeapQueue queue;

            public Consumer(HeapQueue queue, String name) {
                this.queue = queue;
                worker = new Thread(this, name);
                System.out.println("Create thread for " + name);
                worker.start();
            }

            public void run() {
                try {
                    while (!queue.readyToExit) {
//                        if (queue.mutex) {
//                            queue.mutex = false;
//                            queue.get();
//                            queue.mutex = true;
//                        }
                        if (queue.mutexAtomic.getAndSet(false)) {
                            queue.get();
                            queue.mutexAtomic.getAndSet(true);
                        }

                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        HeapQueue queue = new HeapQueue(100000);

        for (int i = 1; i <= 300 ; i++) {
            new Producer(queue, "Producer_" + i);
        }

        for (int i = 1; i <= 300 ; i++) {
            new Consumer(queue, "Consumer_" + i);
        }
//
//        producer.worker.join();
//        consumer1.worker.join();
//        consumer2.worker.join();

//        System.out.println("Program finished!!!");

    }

    public static void execHeapExampleThreadAtomic() throws InterruptedException {
        class Producer implements Runnable {
            Thread worker;
            HeapQueueAtomic queue;

            public Producer(HeapQueueAtomic queue, String name) {
                this.queue = queue;
                worker = new Thread(this, name);
                System.out.println("Create thread for " + name);
                worker.start();
            }

            public void run() {
                try {
                    while (!queue.readyToExit) {
                        queue.put();
//                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class Consumer implements Runnable {
            Thread worker;
            HeapQueueAtomic queue;

            public Consumer(HeapQueueAtomic queue, String name) {
                this.queue = queue;
                worker = new Thread(this, name);
                System.out.println("Create thread for " + name);
                worker.start();
            }

            public void run() {
                try {
                    while (!queue.readyToExit) {
                        queue.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        HeapQueueAtomic queue = new HeapQueueAtomic(70);
        for (int i = 1; i <= 3; i++) {
            new Producer(queue, "Producer_" + i);
        }

        for (int i = 1; i <= 5; i++) {
            new Consumer(queue, "Consumer_" + i);
        }

//        Consumer consumer1 = new Consumer(queue);
//        Consumer consumer2 = new Consumer(queue);

//        producer.worker.join();
//        consumer1.worker.join();
//        consumer2.worker.join();

//        System.out.println("Program finished!!!");

    }

}

