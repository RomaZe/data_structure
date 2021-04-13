package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapMinArray {
    private int[] items;
    private int arraySize = 0; // The same as size() for ArrayList;

    public HeapMinArray(int arrayLength) {
        items = new int[arrayLength];
    }

    private void shiftUp() {
        int k = arraySize - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            int item = items[k];
            int parent = items[p];
            if (item < parent) {
                items[k] = parent;
                items[p] = item;

                k = p;
            } else
                break;
        }
    }

    public void insert(Integer item) {
        if (arraySize == items.length) {
            System.out.println("Array is full!!!");
            throw new ArrayIndexOutOfBoundsException();
        }
        items[arraySize] = item;
        arraySize++;
        shiftUp();
    }

    private void shiftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < arraySize) {
            int min = l;
            int r = l + 1;
            if (r < arraySize) {
                if (items[r] < items[l]) {
                    min++;
                }
            }
            if (items[k] > items[min]) {
                int temp = items[k];
                items[k] = items[min];
                items[min] = temp;
                k = min;
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
            arraySize--;
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
