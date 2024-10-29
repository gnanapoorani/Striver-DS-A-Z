class FloorCeilInSortedArray{
    public  static void main(String[] args){
        int[] nums={1,3,5,6};
        System.out.println(findFloor(nums,4));
        System.out.println(findCeil(nums,4));
    }
    public static int findFloor(int[] nums, int target) {

        int floor=nums.length-1;
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<=target){
                low=mid+1;
                floor=mid;
            }else{
                high=mid-1;
            }
        }
        return floor;
    }

    public static int findCeil(int[] nums, int target) {

        int ceil=nums.length-1;
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>=target){
                high=mid-1;
                ceil=mid;
            }else{
                low=mid+1;
            }
        }
        return ceil;
    }

}