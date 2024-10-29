package TakeYouForward.Stack;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class StackUsingQueue {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int goal = 0;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, right = 0, sum = 0, count = 0;
        while (right < nums.length) {
            if (nums[right] + sum <= goal) {
                sum += nums[right];
                right++;
            } else {
                sum -= nums[left];
                left++;
            }
            if (sum == goal) {
                count++;
            }
        }
        while (left < right) {
            sum -= nums[left];
            left++;

            if (sum == goal) {
                count++;
            }
        }
        return count;

    }
}