import java.util.Scanner;

public class IntervalsBreaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
        }
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scanner.nextInt();
            }
        }
        int[] S = new int[n+1];
        S[0] = 0;
        Utils.mergesort(intervals, (i1, i2) -> i1.end - i2.end);
        for (int j = 1; j <= n; j++) {
            int k = j;
            // Find the first k such that k ends b[k][j] units time before j starts
            for ( ; k > 0 && intervals[j-1].start - intervals[k-1].end < b[k-1][j-1]; k--);
            S[j] = Math.max(S[j-1], S[k]+1);
        }
        System.out.println(S[n]);
    }

    static class Interval {
        final int start, end, bIndex;
        public Interval(int start, int end, int bIndex) {
            this.start = start;
            this.end = end;
            this.bIndex = bIndex;
        }
    }
}
