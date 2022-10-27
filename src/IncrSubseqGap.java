import java.util.Scanner;

public class IncrSubseqGap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n && scanner.hasNextInt(); i++) {
            a[i] = scanner.nextInt();
        }
        int[] S = new int[n];
        S[0] = a[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            int maxSum = 0;
            // Out of the p previous sums, take the largest and add the current element to it
            for (int j = i-1; j >= 0 && j >= i - p; j--) {
                if (a[j] < a[i] && S[j] > maxSum) {
                    maxSum = S[j];
                }
            }
            S[i] = a[i] + maxSum;
            if (S[i] > max) max = S[i];
        }
        System.out.println(max);
    }
}
