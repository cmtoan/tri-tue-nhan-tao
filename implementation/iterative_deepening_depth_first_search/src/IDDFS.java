import java.util.Stack;

public class IDDFS {
    // this is the vertex we are looking for
    private Vertex targetVertex;
    private boolean isTargetFound;
    private int maxLength;

    public IDDFS(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public void search(Vertex root) {
        int depth = 0;
        root.setDepthLevel(0);

        while (!isTargetFound) {
            if (depth > maxLength) {
                System.out.println("The vertex is not found. Depth : " + depth + ", maxLength : " + maxLength);
                break;
            }
            System.out.println();
            System.out.print(depth + ": ");
            dfs(root, depth);
            depth++;
        }

    }

    private void dfs(Vertex source, int depthLevel) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.print(actualVertex + " ");

            if (actualVertex.getName().equals(targetVertex.getName())) {
                System.out.println("The vertex has been found!");
                isTargetFound = true;
                return;
            }

            if (actualVertex.getAdjacentList() != null && actualVertex.getAdjacentList().size() > 0
                    && maxLength < actualVertex.getDepthLevel() + 1) {
                maxLength = actualVertex.getDepthLevel() + 1;
            }

            // IDDFS : not to go as deep as possible in the graph
            if (actualVertex.getDepthLevel() >= depthLevel) {
                continue;
            }

            // standard DFS
            for (Vertex vertex : actualVertex.getAdjacentList()) {
                if (vertex.getDepthLevel() == null) {
                    vertex.setDepthLevel(actualVertex.getDepthLevel() + 1);
                }
                stack.push(vertex);
            }
        }
    }
}
