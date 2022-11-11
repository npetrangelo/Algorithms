import util.LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class NumPaths {
    public static void main(String[] args) {
        // output the number of shortest paths
        // Modified breadth first search:
        // First encounter is first shortest path
        // Every encounter at the same number of hops from s is another shortest path
        // Abort when you finish looking at that level; all remaining paths are longer
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph[a].add(b);
            if (a != b) graph[b].add(a);
        }
        System.out.println(Arrays.toString(graph));
    }
}
