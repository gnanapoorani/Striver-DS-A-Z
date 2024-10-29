package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.Arrays;

class SubsetSumEqualsK {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1};
        System.out.println(subsetSumToK(4, 7, arr));
    }

    static boolean subsetSumToK(int n, int k, int[] arr) {

        //   int[][] dp = new int[n][k];
        //Arrays.fill(dp, -1);
//        return subsetSumToKHelper(arr, k, 0);
       // return subsetSumToKHelperDP(arr, k, 0, dp);
        return subsetSumToKHelperTabulation(n, k, arr);


    }

    /**
     * Recursion but it has overlapping sub problems
     */
    static boolean subsetSumToKHelper(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }
        if ((index == arr.length) && target != 0) {
            return false;
        }
        boolean notTake = subsetSumToKHelper(arr, target, index + 1);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToKHelper(arr, target - arr[index], index + 1);
        }
        return take | notTake;
    }

    /**
     * Dynamic programming
     */

    static boolean subsetSumToKHelperDP(int[] arr, int target, int index, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1 ? true : false;
        }
        if ((index == arr.length) && target != 0) {
            return false;
        }
        boolean notTake = subsetSumToKHelper(arr, target, index + 1);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToKHelper(arr, target - arr[index], index + 1);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    /**
     * Tabulation
     */
    static boolean subsetSumToKHelperTabulation(int n, int target, int[] arr) {
        boolean[][] dp = new boolean[n ][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = false;
        }

        dp[0][arr[0]] = true;
        for (int index = 1; index < n; index++) {
            for (int k = 1; k <= target; k++) {
                boolean notTake = dp[index - 1][target] ;
                boolean take = false;
                if (arr[index] <= target) {
                    take = (dp[index - 1][k - arr[index]] );
                }
                dp[index][k]= (take || notTake);
            }
        }
        return dp[n - 1][target] ;
    }

}