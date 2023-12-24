import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<Vertex> vertexList = buildGraph();

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(vertexList);

        vertexList = buildGraph();
        System.out.println("Run Depth First Search Recursive : ");
        DepthFirstSearchRecursive depthFirstSearchRecursive = new DepthFirstSearchRecursive();
        depthFirstSearchRecursive.dfs(vertexList);
    }
    private static List<Vertex> buildGraph() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbors(List.of(b, c));
        c.addNeighbors(List.of(d));
        d.addNeighbors(List.of(e));

        f.addNeighbors(List.of(g));
        g.addNeighbors(List.of(h));
        h.addNeighbors(List.of(f));

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.addAll(List.of(a, b, c, d, e, f, g, h));
        return vertexList;
    }
}