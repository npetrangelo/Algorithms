import java.util.Scanner;

public class IntervalsBreaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
        }
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        
    }

    static class Interval {
        final int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
