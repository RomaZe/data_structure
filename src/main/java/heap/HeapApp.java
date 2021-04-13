package heap;

import java.util.Arrays;
import java.util.ArrayList;

public class HeapApp {

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
        for (int element : data) {heapMaxArray.insert(element);}
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
        for (int element : data) {heapMinArray.insert(element);}
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
}
