import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {

    // vertex1 is smaller than vertex2 if vertex1.f < vertex2.f (f=g+h)
    @Override
    public int compare(Vertex vertex1, Vertex vertex2) {
        return Double.compare(vertex1.getF(), vertex1.getF());
    }
}
