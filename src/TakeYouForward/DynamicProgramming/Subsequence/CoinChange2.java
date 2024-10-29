package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/solutions/1371738/c-recursion-dp-memoization-dp-tabulation/
 */
class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
       // System.out.println(change2(coins, 2));
        System.out.println(change( 5,coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static int change2(int[] coins, int amount) {
        // return coinChangeHelper(coins,0,amount);
//        int[][] dp = new int[coins.length][amount + 1];
//        for(int[] row:dp){
//            Arrays.fill(row,-1);
//        }
//        return coinChangeHelperDP(coins, 0, amount, dp);
        return change2Tabulation(coins, amount);
    }

    public static int change2Tabulation(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int index = 1; index < coins.length; index++) {
            for (int k = 0; k <= amount; k++) {
                int takeCoin = 0;
                if (coins[index] <= k) {
                    takeCoin = dp[index][k - coins[index]];
                }
                int notTakeCoin = dp[index - 1][k];
                dp[index][k] = takeCoin + notTakeCoin;
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static int coinChangeHelper(int[] coins, int index, int amount) {
        int answer = 0;
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }

        int takeCoin = 0;
        if (coins[index] <= amount) {
            takeCoin = coinChangeHelper(coins, index, amount - coins[index]);
        }
        int notTakeCoin = coinChangeHelper(coins, index + 1, amount);
        answer = takeCoin + notTakeCoin;

        return answer;
    }

    /**
     * DP - 2 changing states index,amount
     */
    public static int coinChangeHelperDP(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int takeCoin = 0;
        if (coins[index] <= amount) {
            takeCoin = coinChangeHelperDP(coins, index, amount - coins[index], dp);
        }
        int notTakeCoin = coinChangeHelperDP(coins, index + 1, amount, dp);
        dp[index][amount]  = takeCoin + notTakeCoin;

        return dp[index][amount];
    }
}