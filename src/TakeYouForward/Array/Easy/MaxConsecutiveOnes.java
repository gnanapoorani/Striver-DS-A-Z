package TakeYouForward.Array.Easy;

class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int nums[] = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int soFar = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                soFar++;
            } else {
                if (max < soFar) {
                    max = soFar;
                }
                soFar = 0;
            }
        }
        return Math.max(soFar, max);
    }

    /**
     * Sliding window approach - 1,1,1,0,0,0,1,1,1,1,0
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxCounter = 0, n = nums.length, cntZeroes = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cntZeroes++;
            }

            while (cntZeroes > k) {
                if (nums[left] == 0) {
                    cntZeroes--;
                }
                left++;
            }
            maxCounter = Math.max(maxCounter, (right - left) + 1);
            right++;
        }
        return maxCounter;
    }
}