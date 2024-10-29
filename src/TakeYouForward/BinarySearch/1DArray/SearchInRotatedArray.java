class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {6};
        int ans = search(nums, 0);
        System.out.println("The first occurence are: "
                + ans);
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        int answer = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                answer = mid;
                return answer;
            }
            if (nums[low] <= nums[mid]) {//sorted Array
                if (target > nums[mid]) {// element does not exist
                    low = mid + 1;
                } else if (target < nums[mid] && target < nums[low]) {// element does not exist
                    low = mid + 1;
                } else if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }
            }else{
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