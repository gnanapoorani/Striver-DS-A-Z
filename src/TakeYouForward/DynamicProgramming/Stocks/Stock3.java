package TakeYouForward.DynamicProgramming.Stocks;

import java.util.Arrays;

class Stock3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitTabulation(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] row : dp) {
            for (int[] subRow : row) {
                Arrays.fill(subRow, -1);
            }
        }
        return maxProfitHelperDP(prices, 0, 0, dp,2);
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

    public static int maxProfitHelperDP(int[] prices, int i, int buy, int[][][] dp,int count) {
        int profit = 0;
        if (i == prices.length || count <=0) {
            return 0;
        }
        if (dp[i][buy][count]!= -1) {
            return dp[i][buy][count];
        }
        if (buy == 1) { //bought the item already - 2 options - either sell now or skip to next
            dp[i][buy][count]=profit = Math.max(maxProfitHelperDP(prices, i + 1, buy, dp,count),
                    prices[i] + maxProfitHelperDP(prices, i + 1, 0, dp,count-1));
        } else {
            //Not bought the item already - 2 options - either buy now or skip to next
            dp[i][buy][count] = profit = Math.max(-prices[i] + maxProfitHelperDP(prices, i + 1, 1, dp, count),
                    maxProfitHelperDP(prices, i + 1, buy, dp, count));
        }
        return profit;
    }
}