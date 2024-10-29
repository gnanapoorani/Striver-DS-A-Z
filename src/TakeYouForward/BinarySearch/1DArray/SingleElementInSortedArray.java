class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,5,5};
        int ans = singleNonDuplicateBest(nums);
        System.out.println("The first occurence are: "
                + ans);
    }
    public static int singleNonDuplicateBest(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }

    public static int singleNonDuplicate(int[] nums) {

        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if(mid % 2 == 0){ //even -> starting new number
                if(nums[mid] == nums[mid - 1]){ //wrong case -> left missing
                    high=mid-2;
                }else{  //left correct -> search in right
                    low=mid;
                }

            }else{ // odd position -previous number
               if(nums[mid] == nums[mid - 1]){ //
                   low=mid+1;  //correct left - moving to right
               }else{
                   high=mid-1; //wrong case - left missing.
               }
            }
        }
        return nums[low];
    }


}