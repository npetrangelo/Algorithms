import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] A = new int[size];
        for (int i = 0; scanner.hasNextInt() && i < size; i++) {
            A[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int length = incrSubseqRecursive(i, A);
            if (length > max) max = length;
        }
        System.out.println(max);
    }

    public static int incrSubseqRecursive(int j, int[] A) {
        if (A.length == 1) return 1;
        int maxLength = 0;
        for (int i = 0; i < j; i++) {
            if (A[i] < A[j]) {
                int length = incrSubseqRecursive(i, A);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength + 1;
    }
}
