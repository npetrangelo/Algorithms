import java.util.Scanner;

public class Donut {
    static Police[] police;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCops = scanner.nextInt();
        police = new Police[numCops];
        for (int i = 0; scanner.hasNextInt() && i < numCops; i++) {
            police[i] = new Police(scanner.nextInt(), scanner.nextInt());
        }
    }

    private static class Police {
        int x, y;
        public Police(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
