import java.util.Scanner;

public class Donut {
    static Police[] police;
    public static void main(String[] args) {
        // Shortest distance location at median of x's and y's
        // Find shortest x distance and y distance separately
        Scanner scanner = new Scanner(System.in);
        int numCops = scanner.nextInt();
        police = new Police[numCops];
        for (int i = 0; scanner.hasNextInt() && i < numCops; i++) {
            police[i] = new Police(scanner.nextInt(), scanner.nextInt());
        }

        int minXDistance = Integer.MAX_VALUE, minYDistance = Integer.MAX_VALUE;
        int x = 0, y = 0;
        for (Police p : police) {
            int xDistance = distanceSum(p.x, 0);
            if (xDistance < minXDistance) {
                minXDistance = xDistance;
                x = p.x;
            }
            int yDistance = distanceSum(0, p.y);
            if (yDistance < minYDistance) {
                minYDistance = yDistance;
                y = p.y;
            }
        }

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
