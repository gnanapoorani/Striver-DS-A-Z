package TakeYouForward.SlidingWindow;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 */
class SubArrWith3DiffIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int atmostK = findSubArrWtihAtmost(nums, k);
        int atmostKLessOne = findSubArrWtihAtmost(nums, k - 1);
        return atmostK - atmostKLessOne;
    }

    public static int findSubArrWtihAtmost(int[] nums, int k) {
        int left = 0, right = 0, cnt = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size()>k){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                map.remove(nums[left],0);
                left++;
            }
            if (map.size() <= k) {
                cnt += right - left + 1;
            }
            right++;
        }
        return cnt;
    }
}