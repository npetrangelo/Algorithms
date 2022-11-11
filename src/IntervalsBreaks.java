import util.LinkedList;

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
        LinkedList<Interval>[] reconstruction = new LinkedList[n+1];
        reconstruction[0] = new LinkedList<>();
        Utils.mergesort(intervals, (i1, i2) -> i1.end - i2.end);
        for (int j = 1; j <= n; j++) {
            int k = j;
            // Find the first k such that k ends b[k][j] units time before j starts
            while (k > 0 && intervals[j-1].start - intervals[k-1].end < b[intervals[k-1].bIndex][intervals[j-1].bIndex]) k--;
            S[j] = Math.max(S[j-1], S[k]+1);
            if (reconstruction[j-1].length() > reconstruction[k].length()+1) {
                reconstruction[j] = LinkedList.shallowCopyOf(reconstruction[j-1]);
            } else {
                reconstruction[j] = LinkedList.shallowCopyOf(reconstruction[k]);
                reconstruction[j].add(intervals[j-1]);
            }
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

        @Override
        public String toString() {
            return String.format("<%d->%d>", start, end);
        }
    }
}
