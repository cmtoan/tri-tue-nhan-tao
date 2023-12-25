# Bài toán mê cung

## I. Bài toán
- Viết thuật toán tìm đường đi ra khỏi một mê cung **NxN**
- Ta có thể trình bày bài toán với một **ma trận NxN**
- Đây là một bài toán quan trọng trong robotics : làm cách nào để di chuyển con robot một cách hiệu quả nhất?
- Ví dụ : máy lau nhà tự động
- Có thể có một số chướng ngại vật nên ta có thể dùng việc quay đầu lại - hoặc ta có thể xây dựng một cây tìm kiếm và dùng depth-first search

## II. Thuật giải

Ta có một số thuật toán để giải bài toán này :

1. Nếu biết mê cung ta có thể dùng các thuật toán của đồ thị có trọng số (weighted graph) : **thuật toán tìm đường đi ngắn nhất của Dijkstra** và **thuật toán tìm kiếm A***
2. Nếu không biết mê cung, ta có thể dùng thuật toán truy ngược (backtracking) : Thuật toán Trémaux hay thuật toán tìm kiếm theo chiều sâu DFS là như nhau.

## II. Giải

````
solve(x,y):
    if reached destination:
        return true
        
    if valid(x,y):
        set(x,y) visited
        
        if solve(x+1,y):
            return true
            
        if solve(x-1,y):
            return true
            
        if solve(x,y+1):
            return true
            
        if solve(x,y-1):
            return true
            
        set(x,y) unvisited
        
    return false
````

## III. Code Java

MazeSolver.java
````
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
````

Main.java
````
public class Main {
    public static void main(String[] args) {

        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {2, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 3},
        };

        MazeSolver mazeSolver = new MazeSolver(map, 1, 0);
        mazeSolver.findWay();
    }
}
````

[xem ở đây](../../implementation/maze_solver/src)
