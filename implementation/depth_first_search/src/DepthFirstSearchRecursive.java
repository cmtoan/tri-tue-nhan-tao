import java.util.List;
public class DepthFirstSearchRecursive {
    public void dfs(List<Vertex> vertexList) {
        // in case we have independent clusters
        for (Vertex vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dsfHelper(vertex);
            }
        }
    }
    private void dsfHelper(Vertex vertex) {
        System.out.println(vertex);

        for (Vertex item : vertex.getAdjacentList()) {
            if (!item.isVisited()) {
                item.setVisited(true);
                dsfHelper(item);
            }
        }
    }
}
