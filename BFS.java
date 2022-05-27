import java.util.*;

public class BFS <V> extends Search<V> {
    public BFS(WeightedGraph<V> graph, V start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, V start) {
        marked.add(start);
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            V cur = queue.remove();
            for (V to : graph.adjacencyList(cur)) {
                if (!marked.contains(to)) {
                    edgeTo.put(to, cur);
                    queue.add(to);
                    marked.add(to);
                }
            }
        }
    }
}
