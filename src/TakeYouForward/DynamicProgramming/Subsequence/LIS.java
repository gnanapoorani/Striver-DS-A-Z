package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/solutions/1326552/optimization-from-brute-force-to-dynamic-programming-explained/
 */
class LIS {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println("lengthOfLIS :  " + lengthOfLIS(nums));
        System.out.println("lengthOfLIS :  " + lengthOfLISTabulation(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lengthOfLISHelper(nums, 0, -1, dp);
    }

    public static int lengthOfLISTabulation(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int i=0;i<=nums.length-1;i++){
            for(int prev=0;prev<=i;prev++){
                int take=0,notTake=0;
                if (prev==-1 ||nums[i] > nums[prev] ) {
                    take = 1 + dp[i+1][i];//take
                }
                notTake = dp[i+1][prev];//notTake
                dp[i][prev+1]=Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
       return null;
    }

    public static int lengthOfLISHelper(int[] nums, int i, int prev,int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return  dp[i][prev+1];
        }
        int take = 0;
        int notTake = 0;
        if (prev==-1 ||nums[i] > nums[prev] ) {
            take = 1 + lengthOfLISHelper(nums, i + 1, i,dp);//take
        }
        notTake = lengthOfLISHelper(nums, i + 1, prev,dp);//notTake
        dp[i][prev+1]=Math.max(take, notTake);
        return Math.max(take, notTake);
    }
}