import java.util.Scanner;

public class LongestIncreasingSubseqDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] A = new int[size];
        for (int i = 0; scanner.hasNextInt() && i < size; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(Utils.longestIncSubSeq(A));
    }
}
