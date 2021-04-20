import heap.HeapApp;

public class Main {

    public static void main(String[] args) {

//        // Run Heap data structure examples
//        HeapApp.execHeapExamples();

        // Run Heap data structure examples with Thread
        try {
            HeapApp.execHeapExampleThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//            HeapApp.execHeapExampleThreadAtomic();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
