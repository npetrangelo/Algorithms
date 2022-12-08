import java.util.Arrays;
import java.util.Scanner;

public class WeightedInversions {
    static int[] permutation;
    static int[] indexMap;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        permutation = new int[size];
        indexMap = new int[size+1];

        for (int i = 0; scanner.hasNextInt() && i < size; i++) {
            permutation[i] = scanner.nextInt();
            indexMap[permutation[i]] = i;
        }
        System.out.println(Arrays.toString(permutation));
//        System.out.println(Arrays.toString(indexMap));
        ReturnType answer = countInversions(permutation);
        System.out.println(String.format("There are %d inversions", answer.count));
    }

    public static ReturnType countInversions(int[] A) {
        if (A.length == 1) {
            return new ReturnType(0, A);
        }

        int m = A.length / 2;
        int[] B = new int[m], C = new int[A.length - m];
        for (int i = 0; i < m; i++) {
            B[i] = A[i];
        }
        for (int i = 0; i < (A.length - m); i++) {
            C[i] = A[m + i];
        }
        System.out.println(Arrays.toString(A));
        ReturnType left = countInversions(B);
        ReturnType right = countInversions(C);
        int midcount = 0, i = 0, j = 0, k = 0;
        while (i < m && j < A.length - m) {
            if (left.permutation[i] <= right.permutation[j]) {
                A[k++] = left.permutation[i++];
            } else {
                midcount += m - i;
//                int w = 0;
//                System.out.println(Arrays.toString(left.permutation));
//                for (int I = i; I < m; I++) {
//                    System.out.println(String.format("I=%d left[%d]=%d right[%d]=%d", I,
//                            indexMap[left.permutation[I]], left.permutation[I],
//                            indexMap[right.permutation[j]], right.permutation[j]));
//                    w += Math.abs(indexMap[left.permutation[I]] - indexMap[right.permutation[j]]);
//                }
//                System.out.println(String.format("Adding %d inversions, summed weights=%d", m - i, w));
                A[k++] = right.permutation[j++];
            }
            System.out.println(String.format("i=%d j=%d", i, j));
            while (i < m) {
                A[k++] = left.permutation[i++];
            }
            while (j < A.length - m) {
                System.out.println(right.permutation[j]);
                A[k++] = right.permutation[j++];
            }
        }

        System.out.println(String.format("%s + %s = %s",
                Arrays.toString(left.permutation),
                Arrays.toString(right.permutation),
                Arrays.toString(A)));

        return new ReturnType(left.count + right.count + midcount, A);
    }

    private static class ReturnType {
        public long count;
        public int[] permutation;

        public ReturnType(long count, int[] permutation) {
            this.count = count;
            this.permutation = permutation;
        }
    }
}
