package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/solutions/1371738/c-recursion-dp-memoization-dp-tabulation/
 */
class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));
    }

    public static int coinChange(int[] coins, int amount) {
       return coinChangeTabulation(coins,amount);
//        Arrays.sort(coins);
//        int n = coins.length;
////        int answer= coinChangeHelper(coins, n - 1, amount, 0);
//        int[][] dp = new int[coins.length][amount + 1];
//        for (int row[] : dp)
//            Arrays.fill(row, -1);
//        int answer = coinChangeHelperDP(coins, n - 1, amount, 0, dp);
//        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static int coinChangeTabulation(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[coins.length][amount + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i <=amount; i++) {
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i] = (int) Math.pow(10, 9);
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int takeCoin = Integer.MAX_VALUE;
                if (coins[ind] <= target) {
                    takeCoin =1+ dp[ind][target - coins[ind]];
                }
                int notTakeCoin = dp[ind-1][target];
                dp[ind][target] = Math.min(takeCoin, notTakeCoin);
            }
        }
        return dp[n-1][amount]== Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }

    public static int coinChangeHelper(int[] coins, int index, int amount, int count) {
        int answer = -1;
        if (amount == 0) {
            return count;
        }
        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        int takeCoin = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            takeCoin = coinChangeHelper(coins, index, amount - coins[index], count + 1);
        }
        int notTakeCoin = coinChangeHelper(coins, index - 1, amount, count);
        answer = Math.min(takeCoin, notTakeCoin);

        return answer;
    }

    /**
     * DP - 2 changing states index,amount
     */
    public static int coinChangeHelperDP(int[] coins, int index, int amount, int count, int[][] dp) {
        int answer = -1;
        if (amount == 0) {
            return count;
        }
        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int takeCoin = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            takeCoin = coinChangeHelperDP(coins, index, amount - coins[index], count + 1, dp);
            dp[index][amount] = takeCoin;
        }
        int notTakeCoin = coinChangeHelperDP(coins, index - 1, amount, count, dp);
        dp[index][amount] = Math.min(takeCoin, notTakeCoin);

        return dp[index][amount];
    }
}