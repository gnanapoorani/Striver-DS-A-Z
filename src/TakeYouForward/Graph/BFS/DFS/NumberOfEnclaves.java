package TakeYouForward.Graph.BFS.DFS;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        System.out.println(numEnclavesDFS(grid));
        System.out.println(numEnclavesBFS(grid));
    }

    /**
     * DFS
     */
    public static int numEnclavesDFS(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        /** Boundary check - Frist row and lost row*/
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                doDFS(grid, 0, i);
            }
            if (grid[row - 1][i] == 1) {
                doDFS(grid, row - 1, i);
            }
        }
        /** Boundary check - Frist column and lost column*/
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                doDFS(grid, i, 0);
            }
            if (grid[i][col - 1] == 1) {
                doDFS(grid, i, col - 1);
            }
        }
        /** Traverse full matrix to know if any 1 those are not reachable from boundaries*/
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void doDFS(int[][] grid, int i, int j) {
        /** Base condition*/
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        doDFS(grid, i + 1, j);//down
        doDFS(grid, i - 1, j);//up
        doDFS(grid, i, j - 1); //left
        doDFS(grid, i, j + 1);//right
        return;
    }

    /**
     * BFS
     */
    public static int numEnclavesBFS(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        /** Boundary check - First row and lost row*/
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new Point(0, i));
            }
            if (grid[row - 1][i] == 1) {
                queue.offer(new Point(row - 1, i));
            }
        }
        /** Boundary check - Frist column and lost column*/
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new Point(i, 0));
            }
            if (grid[i][col - 1] == 1) {
                queue.offer(new Point(i, col - 1));
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int boundaryRow = point.x;
            int boundaryCol = point.y;
grid[boundaryRow][boundaryCol]=0;
            for (int[] dir : dirs) {
                int nextRow = boundaryRow + dir[0];
                int nextCol = boundaryCol + dir[1];
                if (nextCol >= 0 && nextCol <col && nextRow >= 0 && nextRow < row && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 0;
                    queue.offer(new Point(nextRow, nextCol));
                }
            }
        }
        /** Traverse full matrix to know if any 1 those are not reachable from boundaries*/
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}