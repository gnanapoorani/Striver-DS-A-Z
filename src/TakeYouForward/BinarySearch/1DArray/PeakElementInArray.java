class PeakElementInArray {
    public static void main(String[] args) {
        int[] nums = {1,6,2,3,4,5,6};
        int ans = findPeakElement(nums);
        System.out.println("The Peak Element is: "
                + ans);
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return nums[0];
        if(nums[n-1] > nums[n-2]) return nums[n-1];

        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return nums[mid];
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1; // dummy return statement
    }
}