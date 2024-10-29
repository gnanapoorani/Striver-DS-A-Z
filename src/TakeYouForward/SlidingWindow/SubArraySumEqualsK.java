package TakeYouForward.SlidingWindow;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, count = 0;
        for (int n : nums) {
            sum = sum + n;
            if (sum == k) {
                count++;
            }
            int rem=sum-k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}