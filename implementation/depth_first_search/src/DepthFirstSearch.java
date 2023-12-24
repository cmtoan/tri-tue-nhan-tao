import java.util.List;
import java.util.Stack;
public class DepthFirstSearch {
    private Stack<Vertex> stack;
    public DepthFirstSearch() {
        this.stack = new Stack<>();
    }
    public void dfs(List<Vertex> vertexList) {
        // in case we have independent clusters
        for (Vertex vertex : vertexList) {
            if (!vertex.isVisited()) {
                dsfHelper(vertex);
            }
        }
    }
    private void dsfHelper(Vertex vertex) {
        stack.add(vertex);
        vertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println(actualVertex);

            for (Vertex item : actualVertex.getAdjacentList()) {
                if (!item.isVisited()) {
                    item.setVisited(true);
                    stack.add(item);
                }
            }
        }
    }
}
