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
        LinkedList<Integer> queue = new LinkedList<>();
        public BreadthFirst(int start) {
            for (int i = 0; i < degrees.length; i++) {
                seen[i] = false;
            }
            queue.qAdd(start);
        }

        @Override
        public boolean hasNext() {
            return !queue.empty();
        }

        @Override
        public Integer next() {
            int s = queue.pop();
            seen[s] = true;
            int[] neighbors = adjList[s];
            for (int i = 0; i < degrees[s]; i++) {
                if (!seen[neighbors[i]]) {
                    queue.qAdd(neighbors[i]);
                }
            }
            return s;
        }
    }

    class DepthFirst implements Iterator<Integer> {
        boolean[] seen = new boolean[degrees.length];;
        LinkedList<Integer> stack = new LinkedList<>();
        public DepthFirst(int start) {
            for (int i = 0; i < degrees.length; i++) {
                seen[i] = false;
            }
            stack.add(start);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public Integer next() {
            int s = stack.pop();
            seen[s] = true;
            int[] neighbors = adjList[s];
            for (int i = 0; i < degrees[s]; i++) {
                if (!seen[neighbors[i]]) {
                    stack.add(neighbors[i]);
                }
            }
            return s;
        }
    }
}
