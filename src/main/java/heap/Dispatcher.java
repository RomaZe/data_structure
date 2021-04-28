package heap;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private AtomicInteger countProducer = new AtomicInteger(0);
    private ArrayList<Thread> consumers = new ArrayList<>();

    public void addProducer() {
        countProducer.incrementAndGet();
    }

    public void removeProducer() {
        countProducer.decrementAndGet();

//        System.out.println("Notify Consumer!!!");
//        notifyConsumer();
    }

    synchronized public void addConsumer(Thread consumer) {
        consumers.add(consumer);
    }

    public void startDispatcher() {
        while (true) {
            if (countProducer.get() == 0) {
                notifyConsumer();
                break;
            }
        }
    }

    public void notifyConsumer() {
        for (Thread consumer : consumers) {
            consumer.interrupt();
            if (consumer.isAlive()) {
                try {
                    consumer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Graceful shutdown");
    }
}

