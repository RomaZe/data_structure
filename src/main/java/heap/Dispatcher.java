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

        System.out.println("Notify Consumer!!!");
        notifyConsumer();
    }

    synchronized public void addConsumer(Thread consumer) {
        consumers.add(consumer);
    }

    synchronized public void notifyConsumer() {
        if (countProducer.get() == 0) {
            for (Thread consumer : consumers) {
                consumer.interrupt();
            }
        }

        System.out.println("Number of running Producers: " + countProducer.get());
    }
}
