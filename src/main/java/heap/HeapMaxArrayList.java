package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapMaxArrayList<Integer extends Comparable<Integer>> {

    private ArrayList<Integer> items;

    public HeapMaxArrayList() {
        items = new ArrayList<Integer>();
    }

    private void shiftUp() {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            Integer item = items.get(k);
            Integer parent = items.get(p);
            if (item.compareTo(parent) > 0) {
                items.set(k, parent);
                items.set(p, item);

                k = p;
            } else
                break;
        }
    }

    public void insert(Integer item) {
        items.add(item);
        shiftUp();
    }

    private void shiftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < items.size()) {
            int max = l;
            int r = l + 1;
            if (r < items.size()) {
                if (items.get(r).compareTo(items.get(l)) > 0) {
                    max = r;
                }
            }
            if (items.get(k).compareTo(items.get(max)) < 0) {
                Integer temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public Integer delete() throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        Integer hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        shiftDown();
        return hold;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        return items.toString();
    }
}
