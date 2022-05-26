import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, List<Vertex<V>>> map = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(V start, V dest, double w) {
        if (hasVertex(start) == false) addVertex(start);
        if (hasVertex(dest) == false) addVertex(dest);
        if (hasEdge(start, dest) == true || start == dest) return;
        //System.out.println("was added edge: " + start + " -> " + dest);
        map.get(start).add(new Vertex<>(dest, w));
        if (undirected == true) map.get(dest).add(new Vertex<>(start, w));
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (V to : map.keySet()) count += map.get(to).size();
        if (undirected) count /= 2;
        return count;
    }

    public boolean hasVertex(V vertex) {
        if (map.containsKey(vertex)) return true;
        return false;
    }

    public boolean hasEdge(V x, V y) {
        if (hasVertex(x) == false) return false;
        if (map.get(x).contains(new Vertex<>(y))) return true;
        return false;
    }

    public double EdgeLen(V x, V y) {
        for (Vertex to : map.get(x)) {
            if (to.data == y) {
                return to.weight;
            }
        }
        return 0D;
    }

    public Iterable<V> adjacencyList(V x) {
        if (!hasVertex(x)) return null;
        List<V> adj = new LinkedList<>();
        for (Vertex<V> to : map.get(x)) adj.add(to.getAdj());
        return adj;
    }
}

