import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A", 0, 0);
        Vertex vertexB = new Vertex("B", 10, 20);
        Vertex vertexC = new Vertex("C", 20, 40);
        Vertex vertexD = new Vertex("D", 30, 10);
        Vertex vertexE = new Vertex("E", 40, 30);
        Vertex vertexF = new Vertex("F", 50, 10);
        Vertex vertexG = new Vertex("G", 50, 40);

        vertexA.addNeighbors(List.of(new Edge(10, vertexB), new Edge(50, vertexD)));
        vertexB.addNeighbors(List.of(new Edge(10, vertexC), new Edge(20, vertexD)));
        vertexC.addNeighbors(List.of(new Edge(10, vertexE), new Edge(30, vertexG)));
        vertexD.addNeighbors(List.of(new Edge(80, vertexF)));
        vertexE.addNeighbors(List.of(new Edge(50, vertexF), new Edge(10, vertexG)));
        vertexG.addNeighbors(List.of(new Edge(10, vertexF)));

        AStarSearch aStarSearch = new AStarSearch(vertexA, vertexF);
        aStarSearch.run();
        aStarSearch.printSolutionPath();
    }
}