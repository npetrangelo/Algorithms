import java.util.Scanner;

public class MatrixChainParenthesize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i <= n && scanner.hasNextInt(); i++) {
            a[i] = scanner.nextInt();
        }
        int[][] S = new int[n][n];
        for (int L = 0; L < n; L++) {
            S[L][L] = 0;
        }
        for (int d = 0; d < n; d++) {
            for (int L = 0; L < n-d; L++) {
                int R = L+d;
                S[L][R] = Integer.MAX_VALUE;
                for (int k = L; k < R-1; k++) {
                    int tmp = S[L][k] + S[k+1][R] + a[L-1]*a[k]*a[R];
                    if (tmp < S[L][R]) S[L][R] = tmp;
                }
            }
        }
        System.out.println(S[1][n]);
    }
}
