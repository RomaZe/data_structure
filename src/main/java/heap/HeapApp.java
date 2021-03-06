package heap;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeapApp {

    private static boolean stopRequested = false;
    private AtomicBoolean mutexAtomic = new AtomicBoolean(true);
    private Dispatcher dispatcher = new Dispatcher();
    private HeapQueue queue = new HeapQueue(100);


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

    public void execHeapExampleThread() throws InterruptedException {

//        class Producer implements Runnable {
//            Thread worker;
//            public HeapQueue queue;
//
//            public Producer(HeapQueue queue, String name) {
//                this.queue = queue;
//                worker = new Thread(this, name);
//                System.out.println("Create thread for " + name);
//                worker.start();
//
//                queue.dispatcher.takeAction(() -> {
//                    queue.dispatcher.producers.add(worker);
//                });
//            }
//
//            public void run() {
//                try {
////                    Thread.sleep(3000);
//                    while (true) {
//                        if (!Thread.interrupted()) {
//                            if (queue.mutexAtomic.getAndSet(false)) {
//                                queue.put();
//                                queue.mutexAtomic.getAndSet(true);
//                            }
//
//                            Thread.sleep(1000);
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    System.out.printf("Thread %s was interruped by someone calling this Thread.interrupt()", Thread.currentThread().getName());
//                    System.out.println();
////                    e.printStackTrace();
//                }
//            }
//        }
//
//        class Consumer implements Runnable {
//            Thread worker;
//            HeapQueue queue;
//
//            public Consumer(HeapQueue queue, String name) {
//                this.queue = queue;
//                worker = new Thread(this, name);
////                System.out.println("Create thread for " + name);
//                worker.start();
//
//                queue.dispatcher.takeAction(() -> {
//                    queue.dispatcher.consumers.add(worker);
//                });
//            }
//
//            public void run() {
//                try {
//                    while (true) {
//                        if (!Thread.interrupted()) {
//                            if (queue.mutexAtomic.getAndSet(false)) {
//                                queue.get();
//                                queue.mutexAtomic.getAndSet(true);
//                            }
//
//                            Thread.sleep(300);
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    System.out.println("All consumers have been stopped because no any Producers");
//                }
//            }
//
//        }


//        for (int i = 0; i < 3; i++) {
//            new Producer(queue, "Producer_" + i);
//        }
//
//        for (int i = 0; i < 1; i++) {
//            new Consumer(queue, "Consumer_" + i);
//        }

//        // Start Producer
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    try {
////                    Thread.sleep(3000);
//                        while (!queue.readyToExit) {
//                            if (queue.mutexAtomic.getAndSet(false)) {
//                                queue.put();
//                                queue.mutexAtomic.getAndSet(true);
//                            }
//                            Thread.sleep(1000);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
//        }
//
//        // Start Consumer
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    try {
//                        while (!queue.readyToExit) {
//                            if (queue.mutexAtomic.getAndSet(false)) {
//                                queue.get();
//                                queue.mutexAtomic.getAndSet(true);
//                            }
//
//                            Thread.sleep(300);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
//        }
//
        // Producer with lambda function

        // Consumer with lambda function
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                dispatcher.addConsumer(Thread.currentThread());
                try {
                    while (true) {
                        if (!Thread.interrupted()) {
                            if (mutexAtomic.getAndSet(false)) {
                                queue.get();
                                mutexAtomic.getAndSet(true);
                            }

                            Thread.sleep(300);
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.printf("Consumer %s was interrupted because there were no Producers left.\n", Thread.currentThread().getName());
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                dispatcher.addProducer();
                try {
//                    Thread.sleep(3000);
                    boolean isPutSuccess = false;
                    while (true) {
                        if (mutexAtomic.getAndSet(false)) {
                            isPutSuccess = queue.put();
                            mutexAtomic.getAndSet(true);

                            if (!isPutSuccess) {
                                System.out.printf("Producer %s was stopped by someone calling stop request.\n", Thread.currentThread().getName());
                                dispatcher.removeProducer();
                                break;
                            }
                        }

                        Thread.sleep(1000);
                    }


                } catch (InterruptedException e) {
                    System.out.printf("Producer %s was interrupted by someone calling stop request.", Thread.currentThread().getName());
                    System.out.println();
                }
            }).start();

        }

        Thread dispatcherThread = new Thread(() -> dispatcher.startDispatcher());
        dispatcherThread.start();

        if (dispatcherThread.isAlive()) {
            dispatcherThread.join();
        }

        System.out.println("After join");
    }
}

