package heap;

import java.util.ArrayList;

@FunctionalInterface
public interface Observer {
    void sendNotification();
}
