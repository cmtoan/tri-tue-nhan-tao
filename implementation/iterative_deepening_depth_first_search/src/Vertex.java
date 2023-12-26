import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private Integer depthLevel;
    private List<Vertex> adjacentList;

    public Vertex(String name) {
        this.name = name;
        this.adjacentList = new ArrayList<>();
    }

    public List<Vertex> getAdjacentList() {
        return adjacentList;
    }

    public void addNeighbors(List<Vertex> neighbors) {
        this.adjacentList.addAll(neighbors);
    }

    public Integer getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(Integer depthLevel) {
        this.depthLevel = depthLevel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
