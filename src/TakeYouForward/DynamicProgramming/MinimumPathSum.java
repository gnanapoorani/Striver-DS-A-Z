package TakeYouForward.DynamicProgramming;

import java.util.Arrays;

class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minPathSumDP(dp, grid, m - 1, n - 1);
    }

    public static int minPathSumDP(int[][] dp, int[][] grid, int i, int j) {

        if (i == 0 & j == 0) {
            dp[i][j] = grid[i][j];
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up=minPathSumDP(dp,grid,i-1,j);
        int left=minPathSumDP(dp,grid,i,j-1);
        return dp[i][j]=grid[i][j]+Math.min(left,up);

    }
}