import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjacentList;

    public Vertex(String name) {
        this.name = name;
        this.adjacentList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacentList() {
        return adjacentList;
    }

    public void addNeighbors(List<Vertex> neighbors) {
        this.adjacentList.addAll(neighbors);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
