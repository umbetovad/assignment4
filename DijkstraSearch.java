import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Set<V> queue;
    private WeightedGraph<V> g;
    private Map<V, Double> dist;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        dist = new HashMap<>();
        queue = new HashSet<>();
        this.g = graph;
        dijkstra();
    }

    public void dijkstra() {
        dist.put(start, 0D);
        queue.add(start);

        //System.out.println("Dijkstra was started: " + start);

        while (queue.size() > 0) {
            V curVertex = getBestVariable();
            marked.add(curVertex);
            //System.out.println("Vertex: " + curVertex + " was marked");
            queue.remove(curVertex);
            for (V to : g.adjacencyList(curVertex)) {
                double len = getDistTo(curVertex) + getDist(to, curVertex);
                //System.out.println(getDistTo(to) + " " + len + " " + to + " " + curVertex);
                if (getDistTo(to) > len) {
                    dist.put(to, len);
                    edgeTo.put(to, curVertex);
                    queue.add(to);
                }
            }
        }
    }

    private V getBestVariable() {
        V ans = null;
        for (V cur : queue) {
            if (ans == null || getDistTo(cur) < getDistTo(ans)) {
                ans = cur;
            }
        }
        return ans;
    }

    private double getDist(V x, V y) {
        return g.EdgeLen(y, x);
    }

    private double getDistTo(V x) {
        Double len = dist.get(x);
        if (len == null) return 1e9;
        return len;
    }
}
