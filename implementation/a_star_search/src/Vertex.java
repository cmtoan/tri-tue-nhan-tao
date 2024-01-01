import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private double x;
    private double y;

    // parameters for the A* search
    private double g;
    private double h;
    private double f;
    // track the adjacent list (neighbors)
    private List<Edge> adjacentList;
    // it tracks the previous vertex in the shortest path
    private Vertex parent;
    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.adjacentList = new ArrayList<>();
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public List<Edge> getAdjacentList() {
        return adjacentList;
    }

    public void addNeighbors(List<Edge> neighbors) {
        this.adjacentList.addAll(neighbors);
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }
}
