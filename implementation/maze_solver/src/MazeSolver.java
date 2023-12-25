public class MazeSolver {
    private final int startRow;
    private final int startColumn;
    private final int[][] maze;
    private final boolean[][] vistited;

    public MazeSolver(int[][] maze, int startRow, int startColumn) {
        this.maze = maze;
        this.vistited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startColumn = startColumn;
    }

    public void findWay() {
        if (dsf(startRow, startColumn)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No solution exists");
        }
    }

    private boolean dsf(int row, int column) {
        // destination
        if (row == maze.length - 1 && column == maze.length - 1) {
            return true;
        }
        if (isFeasible(row, column)) {
            vistited[row][column] = true;
            // we visit the next cells (up, down, left, right)
            // going down
            if (dsf(row + 1, column)) {
                return true;
            }
            // going up
            if (dsf(row - 1, column)) {
                return true;
            }
            // going right
            if (dsf(row, column + 1)) {
                return true;
            }
            // going left
            if (dsf(row, column - 1)) {
                return true;
            }

            // backtrack
            vistited[row][column] = false;
            return false;
        }

        return false;
    }

    private boolean isFeasible(int x, int y) {
        // check vertical borders
        if (x < 0 || x > maze.length - 1) {
            return false;
        }
        // check horizontal borders
        if (y < 0 || y > maze.length - 1) {
            return false;
        }

        // already visited
        if (vistited[x][y]) {
            return false;
        }

        // there is an obstacle in the way
        if (maze[x][y] == 1) {
            return false;
        }
        return true;
    }
}
