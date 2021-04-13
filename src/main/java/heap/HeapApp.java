package heap;

import java.util.Arrays;
import java.util.ArrayList;

public class HeapApp {

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(33, 55, 44, 77, 88, 11, 22, 99, 1, 66));
        Heap<Integer> hp = new Heap<Integer>();

        for (Integer element : data) {
            hp.insert(element);
        }

        System.out.println("Heap: " + hp);
        System.out.println();

        Integer max = hp.delete();
        System.out.println("Delete max element from Heap. Deleted element:" + max);
        System.out.println("Heap: " + hp);

        Integer el = 111;
        System.out.println("Add element: " + el);
        hp.insert(el);
        System.out.println("Heap: " + hp);
        System.out.println();
    }
}
