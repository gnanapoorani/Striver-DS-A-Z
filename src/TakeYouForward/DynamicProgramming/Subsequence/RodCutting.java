package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.Arrays;

class RodCutting {
    public static void main(String[] args) {
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int price[], int n) {
//        return cutRodHelper(0, price, n);
        int[][] dp= new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return cutRodHelper(0, price, n,dp);
    }

    public static int cutRodHelper(int index, int price[], int n,int[][] dp) {
        int answer = 0;
        if (n == 0) {
            return 0;
        }
        if (index >= price.length) {
            return 0;
        }
        if (dp[index][n]!=-1) {
            return dp[index][n];
        }
        int notTake = 0 + cutRodHelper(index + 1, price, n,dp);
        int take = 0;
        if ((index + 1) <= n) {
            take = price[index] + cutRodHelper(index, price, n - (index + 1),dp);
        }
       dp[index][n]= answer = Math.max(take, notTake);
        return answer;
    }

    /**
     * With for loop
     */
}