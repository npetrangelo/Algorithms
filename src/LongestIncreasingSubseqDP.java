import java.util.Scanner;

public class LongestIncreasingSubseqDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] A = new int[size];
        for (int i = 0; scanner.hasNextInt() && i < size; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(incrSubseqDP(A));
    }

    private static int incrSubseqDP(int[] A) {
        int[] S = new int[A.length];
        int max = 0;
        for (int j = 0; j < A.length; j++) {
            S[j] = 1;
            for (int k = 0; k < j; k++) {
                if (A[k] < A[j] && S[j] < S[k]+1) {
                    S[j] = S[k]+1;
                }
            }
            if (S[j] > max) max = S[j];
        }
        return max;
    }
}
