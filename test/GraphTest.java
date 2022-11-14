import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {
    static Graph graph = new Graph(4, 4);

    @BeforeAll
    static void init() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
    }

    @Test
    void testBFS() {
        Graph.BreadthFirst BFS = graph.breadthFirst(0);
        StringBuilder sb = new StringBuilder();

        while (BFS.hasNext()) {
            sb.append(BFS.next() + ",");
        }
        assertEquals("0,1,2,3,", sb.toString());
    }

    @Test
    void testDFS() {
        Graph.DepthFirst DFS = graph.depthFirst(0);
        StringBuilder sb = new StringBuilder();
        while (DFS.hasNext()) {
            sb.append(DFS.next() + ",");
        }
        assertEquals("0,2,3,1,", sb.toString());
    }
}
