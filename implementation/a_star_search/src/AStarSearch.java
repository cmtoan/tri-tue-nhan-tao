import java.util.*;

public class AStarSearch {
    private Vertex source;
    private Vertex destination;

    private Set<Vertex> exploredVertices;
    private PriorityQueue<Vertex> queue;

    public AStarSearch(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        this.exploredVertices = new HashSet<>();
        this.queue = new PriorityQueue<>(new VertexComparator());
    }

    public void run() {
        queue.add(source);

        while (!queue.isEmpty()) {
            // we always get the vertex with the lowest f(x) value possible
            Vertex current = queue.poll();
            exploredVertices.add(current);

            // we have found the destination vertex
            if (current == destination) {
                break;
            }

            // consider the adjacent vertices
            for (Edge edge : current.getAdjacentList()) {
                Vertex child = edge.getTarget();
                double cost = edge.getWeight();
                double tempG = current.getG() + cost;
                double tempF = tempG + heuristic(current, destination);

                // if we have considered the child and the f(x) is higher
                if (exploredVertices.contains(child) && tempF >= child.getF()) {
                    continue;
                }
                // if we have not visited the child and the f(x) is lower
                else if (!queue.contains(child) || tempF < child.getF()) {
                    // this is how we can track the shortest path (predecessor)
                    child.setParent(current);
                    child.setG(tempG);
                    child.setF(tempF);

                    // if we have it in the queue, but now we have a lower value
                    // instead of update, we remove and reinsert it
                    if (queue.contains(child)) {
                        queue.remove(child);
                    }
                    queue.add(child);
                }
            }
        }
    }

    private double heuristic(Vertex current, Vertex destination) {
        return Math.sqrt(Math.pow(current.getX() - destination.getX(), 2) +
                Math.pow(current.getY() - destination.getY(), 2));
    }

    public void printSolutionPath() {
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex = destination; vertex != null; vertex = vertex.getParent()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        System.out.println(path);
    }
}
