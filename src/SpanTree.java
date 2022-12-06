import java.util.Iterator;
import java.util.Scanner;

public class SpanTree {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph graph = new Graph(n, m);

        for (int i = 0; i < m; i++) {

        }
    }

    private static class UnionFind {
        private int[] boss, size;
        private Set[] set;
        public UnionFind(int[] vertices) {
            boss = new int[vertices.length];
            size = new int[vertices.length];
            set = new Set[vertices.length];
            for (int vertex : vertices) {
                boss[vertex] = vertex;
                size[vertex] = 1;
                set[vertex] = new Set(vertices.length);
                set[vertex].add(vertex);
            }
        }

        public void union(int u, int v) {
            if (size[boss[u]] > size[boss[v]]) {
                set[boss[u]] = set[boss[u]].union(set[boss[v]]);
                size[boss[u]] += size[boss[v]];
                for (int z : set[boss[v]]) {
                    boss[z] = boss[u];
                }
            } else {
                set[boss[v]] = set[boss[v]].union(set[boss[u]]);
                size[boss[v]] += size[boss[u]];
                for (int z : set[boss[u]]) {
                    boss[z] = boss[v];
                }
            }
        }
    }

    private static class Set implements Iterable<Integer>{
        boolean[] set;
        public Set(int maxValue) {
            set = new boolean[maxValue];
        }

        public void add(int value) {
            set[value] = true;
        }

        public Set union(Set that) {
            Set union = new Set(this.set.length);
            for (int i = 0; i < this.set.length; i++) {
                union.set[i] = this.set[i] | that.set[i];
            }
            return union;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private int index = 0;
                @Override
                public boolean hasNext() {
                    index++;
                    while (!set[index]) index++;
                    return true;
                }

                @Override
                public Integer next() {
                    return index;
                }
            };
        }
    }

}
