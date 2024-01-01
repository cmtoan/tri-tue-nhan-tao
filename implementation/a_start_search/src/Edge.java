public class Edge {
    private double weight;
    private Vertex target;

    public Edge(double weight, Vertex target) {
        this.weight = weight;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getTarget() {
        return target;
    }

}
