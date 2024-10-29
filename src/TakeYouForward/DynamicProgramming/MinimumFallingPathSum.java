package TakeYouForward.DynamicProgramming;


class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            int value=minFallingPathSumDP(matrix, dp, 0, i);
            System.out.println(value);
            min=Math.min(value,min);
        }
        return min;
    }

    public static int minFallingPathSumDP(int[][] matrix, int[][] dp, int row, int col) {

        if (col < 0 || col >= matrix[0].length || row >= matrix.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if(row==matrix.length-1){
            return matrix[row][col];
        }
        int down = minFallingPathSumDP(matrix, dp, row + 1, col - 1);
        int leftDiagonal = minFallingPathSumDP(matrix, dp, row + 1, col);
        int rightDiagonal = minFallingPathSumDP(matrix, dp, row + 1, col + 1);

        return dp[row][col] =matrix[row][col]+ Math.min(Math.min(down, leftDiagonal), rightDiagonal);
    }
}