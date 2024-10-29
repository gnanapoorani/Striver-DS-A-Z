class UpperBound{
    public  static void main(String[] args){
        int[] nums={1,3,5,6};
        System.out.println(search(nums,4));
    }
    public static int search(int[] nums, int target) {

        int lowerBound=nums.length-1;
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
                lowerBound=mid;
            }else if(nums[mid]==target){
               return mid;
            }else{
                low=mid+1;
            }
        }
        return lowerBound;
    }

}