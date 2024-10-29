package TakeYouForward.DynamicProgramming.Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change/solutions/1371738/c-recursion-dp-memoization-dp-tabulation/
 */
class TargetSums {
    public static void main(String[] args) {
        int[] coins = {1,1,1,1,1};
        System.out.println(findTargetSumWays(coins, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int finalSum=0;
        for(int num:nums){
            finalSum+=num;
        }
        Map<Integer,Integer> dp=new HashMap<>();

        return findTargetSumWaysHelperDP(nums, 0, target,0, dp);
     //   return findTargetSumWaysHelper(nums, 0, target, 0,dp);
    }

    public static int findTargetSumWaysHelper(int[] nums, int index, int target, int sum) {
        int ways = 0;
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int addPlusBefore = findTargetSumWaysHelper(nums, index + 1, target, sum + nums[index]);
        int addMinusBefore = findTargetSumWaysHelper(nums, index + 1, target, sum - nums[index]);
        ways = addPlusBefore + addMinusBefore;

        return ways;
    }

    /**
     *Dp Array will not work for negative number
     */

    public static int findTargetSumWaysHelperDP(int[] nums, int index, int target,int sum,Map<Integer,Integer> dp) {
        int ways = 0;
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if(dp.get(index)!=null){
            return dp.get(index);
        }
        int addPlusBefore = findTargetSumWaysHelperDP(nums, index + 1, target, sum + nums[index],dp);
        int addMinusBefore = findTargetSumWaysHelperDP(nums, index + 1, target, sum - nums[index],dp);
        ways = addPlusBefore + addMinusBefore;
//        dp[index][sum]=ways;
        return ways;
    }

}