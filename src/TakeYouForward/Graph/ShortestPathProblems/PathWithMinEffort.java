package TakeYouForward.Graph.ShortestPathProblems;

import java.util.*;

/**
 * Good solution
 * https://leetcode.com/problems/path-with-minimum-effort/solutions/1000195/thought-process-from-naive-bfs-to-dijkstra/
 * Naive BFS to dijkstra
 */

class PathWithMinEffort {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(grid));
    }

    public static int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[][] cost = new int[row][col];
        for (int[] cell : cost) {
            Arrays.fill(cell, -1);
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] currCell = pq.poll();
            int currRow = currCell[0];
            int currCol = currCell[1];
            int currHeight = heights[currRow][currCol];
            int currCost = cost[currRow][currCol];

            //iterate all directions
            for (int[] neighbour : dir) {
                int nextRow = currRow + neighbour[0];
                int nextCol = currCol + neighbour[1];

                if (isValidMove(nextRow, nextCol, heights)) {
                    int neighbourCost = cost[nextRow][nextCol];
                    int neighbourHeight = heights[nextRow][nextCol];
                    int newCost = Math.max(currCost, Math.abs(neighbourHeight - currHeight));
                    if (newCost < neighbourCost || neighbourCost == -1) {
                        cost[nextRow][nextCol] = newCost;
                        pq.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        int finalEffort = cost[row - 1][col - 1];
        return finalEffort;
    }

    // If value lies outside the matrix, its not a valid move
    public static boolean isValidMove(int row, int col, int[][] heights) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return false;

        return true;
    }
}