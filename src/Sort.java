import java.util.Comparator;

public class Sort {
    public static <T> void mergesort(T[] a, Comparator<? super T> c, int beg, int end) {
        if (beg >= end) {
            return;
        }

        int mid = (beg + end)/2;
        mergesort(a, c, beg, mid);
        mergesort(a, c, mid + 1, end);
        merge(a, c, beg, mid, end);
    }

    private static <T> void merge(T[] a, Comparator<? super T> c, int beg, int mid, int end) {
        int leftSize = mid - beg + 1, rightSize = end - mid;
        T[] left = (T[]) new Object[leftSize], right = (T[]) new Object[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = a[beg + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = a[mid + 1 + j];
        }

        int i = 0, j = 0, k = beg;
        while (i < leftSize && j < rightSize) {
            a[k++] = (c.compare(left[i], right[j]) < 0) ? left[i++] : right[j++];
        }
        while (i < leftSize) {
            a[k++] = left[i++];
        }
        while (j < rightSize) {
            a[k++] = right[j++];
        }
    }
}