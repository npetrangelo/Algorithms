import java.util.Scanner;

public class Donut {
    static Police[] police;
    public static void main(String[] args) {
        // Shortest distance location at median of x's and y's
        // Find x median and y median separately with linear time median
        Scanner scanner = new Scanner(System.in);
        int numCops = scanner.nextInt();
        police = new Police[numCops];
        int[] xs = new int[numCops], ys = new int[numCops];
        for (int i = 0; scanner.hasNextInt() && i < numCops; i++) {
            xs[i] = scanner.nextInt();
            ys[i] = scanner.nextInt();
            police[i] = new Police(xs[i], ys[i]);
        }

        int x = Utils.selectRand(xs, xs.length/2);
        int y = Utils.selectRand(ys, ys.length/2);

        System.out.println(distanceSum(x, y));
    }

    private static int distanceSum(int x, int y) {
        int sum = 0;
        for (Police p : police) {
            sum += p.distanceFrom(x, y);
        }
        return sum;
    }

    private static class Police {
        private final int x, y;
        public Police(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceFrom(int x, int y) {
            return Math.abs(this.x - x) + Math.abs(this.y - y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
}
