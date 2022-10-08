import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Random random = new Random();
        int[] sizes = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
        int bound = 1000;
        List<int[]> inputs = new ArrayList<>();
        System.out.println("Dynamic Programming");
        for (int size : sizes) {
            int[] A = random.ints(size, 0, bound).toArray();
            inputs.add(A);
            long start = System.nanoTime();
            Utils.longestIncSubSeq(A);
            long end = System.nanoTime();
            System.out.println(end - start);
        }
        System.out.println("Recursive");
        for (int[] A : inputs) {
            long start = System.nanoTime();
            for (int i = 0; i < A.length; i++) {
                LongestIncreasingSubseqRecursive.incrSubseqRecursive(i, A);
            }
            long end = System.nanoTime();
            System.out.println(end - start);
        }
    }
}
