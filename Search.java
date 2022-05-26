import java.util.*;

public class Search<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V start;

    public Search(V start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public Iterable<V> pathTo(V v) {
        if (marked.contains(v) == false) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V i = v; i != start; i = edgeTo.get(i)) path.push(i);
        path.push(start);
        return path;
    }
}