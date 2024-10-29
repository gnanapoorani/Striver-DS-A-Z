package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.Arrays;
class UnboundKnapsack {
    public static void main(String[] args) {
        int[] val = {1, 1};
        int[] wt = {2, 1};
        System.out.println(knapSack(2, 2, val, wt));
    }

    static int knapSack(int N, int W, int val[], int wt[]) {

        int[][] dp= new int[N][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return knapSackHelper(0, W, val, wt,dp);
    }

    static int knapSackHelper(int index, int maxWeight, int val[], int wt[],int[][] dp) {

        if (maxWeight == 0) {
            return 0;
        }
        if(index >=wt.length){
            return 0;
        }
        if(dp[index][maxWeight]!=-1){
            return dp[index][maxWeight];
        }
        int answer = 0;
        int notTake = 0 + knapSackHelper(index + 1, maxWeight, val, wt,dp);
        int take = 0;
        if (wt[index] <= maxWeight) {
            take = val[index] + knapSackHelper(index, maxWeight - wt[index], val, wt,dp);
        }
        dp[index][maxWeight]=answer = Math.max(take, notTake);
        return answer;
    }

    static int knapSackHelperTabulation(int N, int W, int val[], int wt[]) {

        int[][] dp= new int[N][W+1];

        for(int w=0;w<=W;w++ ){
            if(wt[0]<=w){
                dp[0][w]=(w/wt[0])*val[0];
            }

        }
        for(int index=1;index<N;index++){
            for(int maxWeight=0;maxWeight<=W;maxWeight++){
                int notTake = 0 + dp[index - 1][maxWeight];
                int take = 0;
                if (wt[index] <= maxWeight) {
                    take = val[index] + dp[index][ maxWeight - wt[index]];
                }
                dp[index][maxWeight] = Math.max(take, notTake);
            }
        }

        return dp[N-1][W];
    }
}