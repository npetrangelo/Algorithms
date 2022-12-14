package util;

import java.util.Comparator;

public class Heap<T> {
    private int size = 0;
    private T[] arr;
    Comparator<T> c;

    public Heap(int maxSize, Comparator<T> c) {
        arr = (T[]) new Object[maxSize+1];
        this.c = c;
    }

    public T extractMin() throws EmptyHeapException {
        if (size <= 0) throw new EmptyHeapException();
        T min = arr[1];
        arr[1] = arr[size-1];
        size--;
        heapifyDown(1);
        return min;
    }

    public void add(T i) {
        size++;
        arr[size] = i;
        heapifyUp(size);
    }

    public void changeKeyValue(int i, T value) {
        if (c.compare(value, arr[i]) > 0) {
            arr[i] = value;
            heapifyDown(i);
        } else {
            arr[i] = value;
            heapifyUp(i);
        }
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 1 && c.compare(arr[i], arr[parent(i)]) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int j;
        while ((left(i)  <= size && c.compare(arr[i], arr[left(i)])  > 0)
            || (right(i) <= size && c.compare(arr[i], arr[right(i)]) > 0)) {
            j = (c.compare(arr[left(i)], arr[right(i)]) < 0) ? left(i) : right(i);
            swap(i, j);
            i = j;
        }
    }

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return 2*i;
    }

    private int right(int i) {
        return 2*i + 1;
    }

    public static class EmptyHeapException extends Exception {
        public EmptyHeapException() {
            super("Can't extract minimum from empty heap");
        }
    }
}
