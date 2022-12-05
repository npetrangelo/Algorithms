public class Heap {
    private int size = 0;
    private int[] arr;

    public Heap(int maxSize) {
        arr = new int[maxSize+1];
    }

    public int extractMin() throws EmptyHeapException {
        if (size <= 0) throw new EmptyHeapException();
        int min = arr[1];
        arr[1] = arr[size-1];
        size--;
        heapifyDown(1);
        return min;
    }

    public void add(int i) {
        size++;
        arr[size] = i;
        heapifyUp(size);
    }

    public void changeKeyValue(int i, int value) {
        if (value > arr[i]) {
            arr[i] = value;
            heapifyDown(i);
        } else {
            arr[i] = value;
            heapifyUp(i);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 1 && arr[i] < arr[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int j;
        while ((left(i)  <= size && arr[i] > arr[left(i)])
            || (right(i) <= size && arr[i] > arr[right(i)])) {
            j = (arr[left(i)] < arr[right(i)]) ? left(i) : right(i);
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

    public class EmptyHeapException extends Exception {
        public EmptyHeapException() {
            super("Can't extract minimum from empty heap");
        }
    }
}
