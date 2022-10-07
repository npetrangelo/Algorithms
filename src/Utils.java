import java.util.Comparator;

public class Utils {

    public static int[] copyOfRange(int[] A, int from, int to) {
        int newLength = to - from + 1;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        int[] copy = new int[newLength];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = A[i+from];
        }
        return copy;
    }

    public static int selectRand(int[] A, int k) {
        if (A.length == 1) return A[0];
        int i = (int) (A.length * Math.random());
        int x = A[i];
        int[] newA = new int[A.length];
        int front = 0, back = A.length - 1;
        for (int index = 0; index < A.length; index++) {
            if (A[index] < x) {
                newA[front++] = A[index];
            } else if (A[index] > x) {
                newA[back--] = A[index];
            }
        }
        for (int index = front; index <= back; index++) {
            newA[index] = x;
        }
        if (k < front) return selectRand(Utils.copyOfRange(newA, 0, front - 1), k);
        if (k > back) return selectRand(Utils.copyOfRange(newA, back + 1, newA.length - 1), k - (back+1));
        return x; // k between front and back
    }

    public static void mergesort(int[] a) {
        Integer[] copy = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        mergesort(copy, (i, j) -> i - j);
        for (int i = 0; i < a.length; i++) {
            a[i] = copy[i];
        }
    }
    public static <T> void mergesort(T[] a, Comparator<? super T> c) {
        mergesort(a, c, 0, a.length-1);
    }

    private static <T> void mergesort(T[] a, Comparator<? super T> c, int beg, int end) {
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
