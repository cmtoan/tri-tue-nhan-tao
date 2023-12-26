import java.util.List;

public class Main {
    public static void main(String[] args) {
        testFound(getVertices());
        testNotFound(getVertices());
    }

    private static Vertices getVertices() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        return new Vertices(a, b, c, d, e, f, g, h);
    }

    private record Vertices(Vertex a, Vertex b, Vertex c, Vertex d, Vertex e, Vertex f, Vertex g, Vertex h) {
    }

    private static void testFound(Vertices vertices) {
        vertices.a.addNeighbors(List.of(vertices.b, vertices.c));
        vertices.c.addNeighbors(List.of(vertices.d));
        vertices.d.addNeighbors(List.of(vertices.e, vertices.g));
        vertices.e.addNeighbors(List.of(vertices.f, vertices.g));
        vertices.f.addNeighbors(List.of(vertices.g));
        vertices.g.addNeighbors(List.of(vertices.h));
        vertices.h.addNeighbors(List.of(vertices.f));

        IDDFS iddfs = new IDDFS(vertices.f);
        iddfs.search(vertices.a);
    }

    private static void testNotFound(Vertices vertices) {
        vertices.a.addNeighbors(List.of(vertices.b, vertices.c));
        vertices.c.addNeighbors(List.of(vertices.d));
        vertices.d.addNeighbors(List.of(vertices.e));
        vertices.f.addNeighbors(List.of(vertices.g));
        vertices.g.addNeighbors(List.of(vertices.h));
        vertices.h.addNeighbors(List.of(vertices.f));

        IDDFS iddfs = new IDDFS(vertices.f);
        iddfs.search(vertices.a);
    }
}