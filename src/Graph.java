import java.util.Iterator;

public class Graph {
    private final int[] degrees;
    private final int[][] adjList;

    public Graph(int numVertices, int numEdges) {
        degrees = new int[numVertices];
        adjList = new int[numVertices][numEdges];
    }

    public void addEdge(int start, int end) {
        adjList[start][degrees[start]] = end;
        degrees[start]++;
        if (start == end) {
            return;
        }
        adjList[end][degrees[end]] = start;
        degrees[end]++;
    }

    public BreadthFirst breadthFirst(int start) {
        return new BreadthFirst(start);
    }

    public DepthFirst depthFirst(int start) {
        return new DepthFirst(start);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjList.length; i++) {
            sb.append(i + ": [");
            for (int j = 0; j < degrees[i]; j++) {
                sb.append(adjList[i][j] + ",");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    class BreadthFirst implements Iterator<Integer> {
        boolean[] seen = new boolean[degrees.length];
        Queue<Integer> queue = new Queue<>();
        public BreadthFirst(int start) {
            for (int i = 0; i < degrees.length; i++) {
                seen[i] = false;
            }
            seen[start] = true;
            queue.add(start);
        }

        @Override
        public boolean hasNext() {
            return !queue.empty();
        }

        @Override
        public Integer next() {
            int s = queue.poll();
            int[] neighbors = adjList[s];
            for (int i = 0; i < degrees[s]; i++) {
                if (!seen[neighbors[i]]) {
                    seen[neighbors[i]] = true;
                    queue.add(neighbors[i]);
                }
            }
            return s;
        }
    }

    class DepthFirst implements Iterator<Integer> {
        boolean[] seen = new boolean[degrees.length];;
        Stack<Integer> stack = new Stack<>();
        public DepthFirst(int start) {
            for (int i = 0; i < degrees.length; i++) {
                seen[i] = false;
            }
            seen[start] = true;
            stack.add(start);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public Integer next() {
            int s = stack.pop();
            int[] neighbors = adjList[s];
            for (int i = 0; i < degrees[s]; i++) {
                if (!seen[neighbors[i]]) {
                    seen[neighbors[i]] = true;
                    stack.add(neighbors[i]);
                }
            }
            return s;
        }
    }
}
