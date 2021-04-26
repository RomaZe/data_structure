package heap;

import java.util.ArrayList;

public class Dispetcher {

    ArrayList<Thread> producers = new ArrayList<>();
    ArrayList<Thread> consumers = new ArrayList<>();

    synchronized public void addProducer (Event event) {
        event.doTask();
        System.out.println("Add Producer");
    };

    synchronized public void removeProducer (Event event) {
        event.doTask();
    };

    synchronized public void addConsumer (Event event) {
        event.doTask();
        System.out.println("Add Consumer");
    };

    synchronized public void removeConsumer (Event event) {
        event.doTask();
    };
}
