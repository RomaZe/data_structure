package heap;

import java.util.Arrays;
import java.util.ArrayList;

public class HeapApp {

    public static void execHeapExamples() {

        // Generate data for Heap
        Integer[] data = {33, 55, 44, 77, 88, 11, 22, 99, 1, 66};
//        Integer[] data = {};
//        Integer[] data = {100};

        Integer newElement = 111;


        // Create Heap based on ArrayList<Integer>
        System.out.println("============ Max Heap based on ArrayList ==========================\n");

        HeapMaxArrayList<Integer> hp = new HeapMaxArrayList<Integer>();

        // Insert data
        for (Integer element : data) {
            hp.insert(element);
        }

        System.out.println("Heap: " + hp);
        System.out.println();

        Integer max = hp.delete();
        System.out.println("Delete max element from Heap. Deleted element: " + max);
        System.out.println("Heap: " + hp);
        System.out.println();

        hp.insert(newElement);
        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + hp);
        System.out.println();


        // Create Heap based on Array
        System.out.println("============ Max Heap based on Array =============================\n");

        HeapMaxArray heapMin = new HeapMaxArray(15);

        for (int element : data) {
            heapMin.insert(element);
        }

        System.out.println("Heap: " + heapMin);
        System.out.println();

        int deletedHeapMin = heapMin.delete();
        System.out.println("Delete max element from Heap. Deleted element: " + deletedHeapMin);
        System.out.println("Heap: " + heapMin);
        System.out.println();


        heapMin.insert(newElement);

        System.out.println("Add new element: " + newElement);
        System.out.println("Heap: " + heapMin);
        System.out.println();

        // Output results


    }
}
