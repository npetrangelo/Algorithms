import java.util.Arrays;
import java.util.Comparator;

public class Selector {
    private static int MAGIC = 5;
    public static int select(int[] A, int k) {
        if (A.length == 1) return A[0];
        Integer[][] arrays = new Integer[(int) Math.ceil(A.length/(double)MAGIC)][MAGIC];
        for (int i = 0; i < A.length; i++) {
            arrays[i/MAGIC][i%MAGIC] = A[i];
        }
        int[] B = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            B[i] = simpleMedian(arrays[i]);
        }

        int medianB = select(B, B.length/2);

        int[] newA = new int[A.length];
        int front = 0, back = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < medianB) {
                newA[front++] = A[i];
            } else if (A[i] > medianB) {
                newA[back--] = A[i];
            }
        }
        for (int i = front; i <= back; i++) {
            newA[i] = medianB;
        }
        int j = A.length/2;
        if (j < front) {
            j = front;
        } else if (j > back) {
            j = back;
        }

        if (k == j) return medianB;
        if (k < j) return select(Arrays.copyOfRange(newA, 0, j), k);
        return select(Arrays.copyOfRange(newA, j+1, A.length), k - j);
    }

    private static int simpleMedian(Integer[] A) {
        int numNulls = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) numNulls++;
        }
        int[] copyA = new int[A.length - numNulls];
        for (int i = 0; i < copyA.length; i++) {
            copyA[i] = A[i];
        }
        Sort.mergesort(copyA);
        return copyA[copyA.length/2];
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
        int j = A.length/2;
        if (j < front) {
            j = front;
        } else if (j > back) {
            j = back;
        }
        if (k == j) return x;
        if (k < j) return selectRand(Arrays.copyOfRange(newA, 0, j), k);
        return selectRand(Arrays.copyOfRange(newA, j+1, A.length+1), k - j);
    }
}
