package TakeYouForward.DynamicProgramming.Stocks;

import java.util.Arrays;

class cooldown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitTabulation(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxProfitHelperDP(prices, 0, 0, dp);
    }

    public static int maxProfitTabulation(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[0][0]=0;
        dp[0][1]=0;
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) { //bought the item already - 2 options - either sell now or skip to next
                    dp[i][j] = Math.max(dp[i - 1][1], -prices[i-1] + dp[i - 1][0]);
                } else {
                    //Not bought the item already - 2 options - either buy now or skip to next
                    dp[i][j] = Math.max(prices[i-1] + dp[i - 1][1], dp[i - 1][0]);
                }
            }
        }
        return Math.max(dp[prices.length ][0], dp[prices.length][1]);
    }

    public static int maxProfitHelperDP(int[] prices, int i, int buy, int[][] dp) {
        int profit = 0;
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        if (buy == 1) { //bought the item already - 2 options - either sell now or skip to next
            dp[i][buy] = profit = Math.max(maxProfitHelperDP(prices, i + 1, buy, dp),
                    prices[i] + maxProfitHelperDP(prices, i + 2, 0, dp));
        } else {
            //Not bought the item already - 2 options - either buy now or skip to next
            dp[i][buy] = profit = Math.max(-prices[i] + maxProfitHelperDP(prices, i + 1, 1, dp),
                    maxProfitHelperDP(prices, i + 1, 0, dp));
        }
        return profit;
    }
}