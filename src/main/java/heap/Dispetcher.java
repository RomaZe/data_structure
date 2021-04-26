package heap;

import java.util.ArrayList;

public class Dispetcher {

    ArrayList<Thread> producers = new ArrayList<>();
    ArrayList<Thread> consumers = new ArrayList<>();

    synchronized public void takeAction (Event event) {
        event.doTask();
    };
}
