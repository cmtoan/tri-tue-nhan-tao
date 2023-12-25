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