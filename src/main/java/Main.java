import heap.HeapApp;

public class Main {

    public static void main(String[] args) {

//        // Run Heap data structure examples
//        HeapApp.execHeapExamples();

        // Run Heap data structure examples with Thread
        HeapApp myApp = new HeapApp();
        try {
            myApp.execHeapExampleThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
