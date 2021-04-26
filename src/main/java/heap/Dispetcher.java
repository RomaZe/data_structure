package heap;

import java.util.ArrayList;

public class Dispetcher {

    ArrayList<Thread> producers = new ArrayList<>();
    ArrayList<Thread> consumers = new ArrayList<>();

    synchronized public void registerProducer(Thread producer) {
        producers.add(producer);
//        System.out.println("Add producer. Name: " + producer.getName() + " ID: " + producer.getId());
    }

    synchronized public void removeProducer(Thread producer) {
        producers.remove(producer);
        producer.interrupt();
    }

    synchronized public void registerConsumer(Thread consumer) {
        consumers.add(consumer);
    }

    synchronized public void removeConsumer(Thread consumer) {
        consumers.remove(consumer);
    }

    synchronized public void notifyConsumers() {
        if (producers.size() == 0) {
            for (Thread consumer : consumers) {
                consumer.interrupt();
            }
        }
    }
}
