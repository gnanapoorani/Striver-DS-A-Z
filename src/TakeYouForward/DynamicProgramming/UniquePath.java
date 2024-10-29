package TakeYouForward.DynamicProgramming;

import java.util.Arrays;

class UniquePath {
    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));
    }

    /**
     * Normal recurrsion
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -2);

        int[][] maze = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsRecursionDP(dp, m - 1, n - 1));
        System.out.println(uniquePathsRecursionDPObstacle(dp, maze,m - 1, n - 1));
        return uniquePathsRecursion(dp, m - 1, n - 1);
    }

    /**
     * Backtracking
     */
    public static int uniquePathsRecursion(int[][] dp, int i, int j) {

        if (i == 0 && j == 0) {
            return 1;
        }
        int count = 0;
        if (i - 1 > -1 && dp[i - 1][j] != -1) {
            dp[i - 1][j] = -1;
            count += uniquePathsRecursion(dp, i - 1, j);
        }
        if (j - 1 > -1 && dp[i][j - 1] != -1) {
            dp[i][j - 1] = -1;
            count += uniquePathsRecursion(dp, i, j - 1);
        }
        if (i - 1 > -1) {
            dp[i - 1][j] = 0;
        }
        if (j - 1 > -1) {
            dp[i][j - 1] = 0;
        }

        return count;
    }

    /**
     * Dynamic programming
     */

    public static int uniquePathsRecursionDP(int[][] dp, int i, int j) {

        if (i == 0 && j == 0) {
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if (dp[i][j] != -2) {
            return dp[i][j];
        }

        int count = 0;

        count += uniquePathsRecursionDP(dp, i - 1, j);

        count += uniquePathsRecursionDP(dp, i, j - 1);

        dp[i][j] = count;

        return count;
    }

    public static int uniquePathsRecursionDPObstacle(int[][] dp, int[][] maze,int i, int j) {

        if (i == 0 && j == 0) {
            return 1;
        }
        if(i<0 || j<0 || maze[i][j]==1){
            return 0;
        }
        if (dp[i][j] != -2) {
            return dp[i][j];
        }

        int count = 0;

        count += uniquePathsRecursionDPObstacle(dp,maze, i - 1, j);

        count += uniquePathsRecursionDPObstacle(dp,maze, i, j - 1);

        dp[i][j] = count;

        return count;
    }
}