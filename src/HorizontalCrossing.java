import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HorizontalCrossing {

    static Point[] points;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertices = scanner.nextInt();
        points = new Point[numVertices];

        points[0] = new Point(scanner.nextInt(), scanner.nextInt());
        for (int i = 1; scanner.hasNextInt() && i < numVertices; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            points[i].ccw = points[i-1];
            points[i-1].cw = points[i];
        }

        points[0].ccw = points[numVertices-1];
        points[numVertices-1].cw = points[0];
//        System.out.println(Arrays.toString(points));

        // sort points low y to high y
        Sort.mergesort(points, (p1, p2) -> {
            if (p1.y != p2.y) {
                return p1.y - p2.y;
            }
            // Local maxes to the left so old intersections are removed before new ones are added
            if (p1.isLocalMax()) {
                return -1;
            }
            if (p2.isLocalMax()) {
                return 1;
            }
            return 0;
        });

//        System.out.println(Arrays.toString(points));
        int numIntersections = 0, maxIntersections = 0;

        for (Point p : points) {
            if (p.isLocalMin()) {
                numIntersections += 2;
            }
            if (p.isLocalMax()) {
                numIntersections -= 2;
            }
//            System.out.println(p + String.format(" point, %d intersections", numIntersections));
            if (numIntersections > maxIntersections) {
                maxIntersections = numIntersections;
            }
        }

        System.out.println(maxIntersections);
    }

    private static class Point {
        public int x, y;

        public Point ccw, cw;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isLocalMin() {
            return y < ccw.y && y < cw.y;
        }

        public boolean isLocalMax() {
            return y > ccw.y && y > cw.y;
        }

        @Override
        public String toString() {
            return String.format("(%d <- %d -> %d)", ccw.y, y, cw.y);
        }
    }
}
