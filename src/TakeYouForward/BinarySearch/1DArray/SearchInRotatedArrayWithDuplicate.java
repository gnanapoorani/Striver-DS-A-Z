class SearchInRotatedArrayWithDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        boolean ans = search(nums, 0);
        System.out.println("The first occurence are: "
                + ans);
    }

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        boolean answer = false;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                answer = true;
                return answer;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (nums[low] <= nums[mid]) {//sorted Array
                if (target > nums[mid]) {// element does not exist
                    low = mid + 1;
                } else if (target < nums[mid] && target < nums[low]) {// element does not exist
                    low = mid + 1;
                } else if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }
            }else if(nums[low] > nums[mid]){
                if(target<nums[mid] && target <= nums[low]){
                    high=mid-1;
                }else if(target>nums[mid]  && target <nums[low]){
                   low=mid+1;
               }else if(target>nums[mid] && target >= nums[low]){
                   high=mid-1;
               }
            }
        }

        return answer;
    }

}