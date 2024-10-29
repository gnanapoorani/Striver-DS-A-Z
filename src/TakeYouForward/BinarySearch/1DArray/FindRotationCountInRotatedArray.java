class FindRotationCountInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        int ans = findRotationCount(nums);
        System.out.println("The total rotation is: "
                + ans);
    }

    public static int findRotationCount(int[] nums) {
        int minimum = nums[0];
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if(nums[low] <= nums[high]){
                return low;
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