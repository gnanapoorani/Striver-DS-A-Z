package TakeYouForward.Graph.ShortestPathProblems;


import java.util.LinkedList;
import java.util.Queue;

class BinaryMatrixShortestPath {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;
        int pathLength = 0;
        boolean[][] visited = new boolean[row][col];
        //Base Condition
        if (grid[0][0] != 0 || grid[row - 1][col - 1] != 0) {
            return -1;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue.add(new int[]{0, 0});


        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            for (int i = 0; i < size; i++) { // start 8-directional adjacent traversal
                int[] currentCell = queue.poll();
                if (currentCell[0] == row - 1 && currentCell[1] == col - 1) { //if reached bottom right cell
                    return pathLength;
                }
                for (int[] dir : directions) { // 8 direction
                    int nextRow = currentCell[0] + dir[0];
                    int nextCol = currentCell[1] + dir[1];
                    if (nextRow >= 0 && nextRow <= row - 1
                            && nextCol >= 0 && nextCol <= col - 1
                            && grid[nextRow][nextCol] == 0
                            && visited[nextRow][nextCol] == false) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return -1;
    }
}