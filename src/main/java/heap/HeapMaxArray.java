package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapMaxArray {
    private int[] items;
    private int arraySize = 0; // The same as size() for ArrayList;

    public HeapMaxArray(int arrayLength) {
        items = new int[arrayLength];
    }

    private void shiftUp() {
        int k = arraySize - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            int item = items[k];
            int parent = items[p];
            if (item > parent) {
                items[k] = parent;
                items[p] = item;

                k = p;
            } else
                break;
        }
    }

    public void insert(Integer item) {
        items[arraySize] = item;
        arraySize++;
        shiftUp();
    }

    private void shiftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < arraySize) {
            int max = l;
            int r = l + 1;
            if (r < arraySize) {
                if (items[r] > items[l]) {
                    max++;
                }
            }
            if (items[k] < items[max]) {
                int temp = items[k];
                items[k] = items[max];
                items[max] = temp;
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public Integer delete() throws NoSuchElementException {
        if (arraySize == 0) {
            System.out.println("Array is empty!!!");
            throw new NoSuchElementException();
        }
        if (arraySize == 1) {
            int deletedItem = items[0];
            items[0] = 0;
            return deletedItem;
        }
        int hold = items[0];
        items[0] = items[arraySize - 1];
        items[arraySize - 1] = 0;
        arraySize--;
        shiftDown();
        return hold;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
