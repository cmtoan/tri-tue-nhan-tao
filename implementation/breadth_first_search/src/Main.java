import java.util.List;

public class Main {
    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbors(List.of(b, f, g));
        b.addNeighbors(List.of(a, c, d));
        c.addNeighbors(List.of(b));
        d.addNeighbors(List.of(b, e));
        f.addNeighbors(List.of(a));
        g.addNeighbors(List.of(a, h));
        h.addNeighbors(List.of(g));

        breadthFirstSearch.traverse(a);
    }
}