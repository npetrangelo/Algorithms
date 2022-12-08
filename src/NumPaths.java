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
        Graph graph = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph.addEdge(a, b);
        }
        System.out.println(graph);
        for (int node : graph.BFS(0)) {
            System.out.println(node);
        }
    }
}
