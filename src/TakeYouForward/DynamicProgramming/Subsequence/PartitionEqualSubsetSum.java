package TakeYouForward.DynamicProgramming.Subsequence;


import java.util.Arrays;

class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {

        int finalSum = 0;
        for (int num : nums) {
            finalSum += num;
        }
        if (finalSum % 2 != 0) {
            return false;
        } else {
            int target = finalSum / 2;
            int[][] dp = new int[nums.length + 1][target + 1];
            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
            return subsetSumToKHelperDP(nums, target, 0, dp);
        }

    }

    /**
     * Recursion but it has overlapping sub problems
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
        boolean notTake = subsetSumToKHelperDP(arr, target, index + 1, dp);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToKHelperDP(arr, target - arr[index], index + 1, dp);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    /**
     * Dynamic programming - Tabulation
     */

    static boolean canPartitionHelperTabulation(int[] arr, int target, int index) {

        boolean[][] dp = new boolean[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int k = target; k <= target; k++) {
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if (arr[index] <= target) {
                    take = dp[index - 1][target - arr[index]];
                }
                dp[index][target] = (take | notTake);
            }
        }
        return dp[arr.length - 1][target];
    }


}