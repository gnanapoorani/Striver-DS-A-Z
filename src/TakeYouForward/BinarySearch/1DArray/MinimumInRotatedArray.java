class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int ans = findMin(nums);
        System.out.println("The minimum number is: "
                + ans);
    }

    public static int findMin(int[] nums) {
        int minimum = nums[0];
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if(nums[low] <= nums[high]){
                minimum = nums[low];
                return minimum;
            }
            if (nums[low] <= nums[mid] ) { //rotated array
                low = mid + 1;
            } else if (nums[low] > nums[mid]) {
              high=mid;
            }
        }
        return minimum;
    }
}