class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, -1, 0};
        System.out.println(subarraySum(arr, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0, sum = nums[0];
        while (right < nums.length) {
            while (left < right && sum > k) {
                sum = sum - nums[left];
                left++;
            }

            while (left < right && right == nums.length - 1 && sum < k) {
                sum = sum - nums[left];
                left++;
            }

            while (left < right && right == nums.length - 1) {
                sum = sum - nums[left];
                left++;
                if (sum == k) {
                    count++;
                }
            }
            if (sum == k) {
                count++;
            }
            right++;
            if (right < nums.length) {
                sum += nums[right];
            }

        }
        return count;
    }
}