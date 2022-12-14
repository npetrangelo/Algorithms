import util.LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectGraph {
    public static void main(String[] args) {
        // output the smallest number of edges that need to be added to make the graph connected.
        // The number of unconnected trees - 1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
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
