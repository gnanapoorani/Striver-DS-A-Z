class BinarySearch{
    public  static void main(String[] args){
        int[] nums={2};
        System.out.println(search(nums,2));
    }
    public static int search(int[] nums, int target) {

        int foundIndex=-1;
        int n=nums.length;
        int low=0,mid=n/2,high=n-1;
        while(low<=high){
            if(target==nums[mid]){
                foundIndex=mid;
                return  foundIndex;
            }
            if(target<nums[mid]){
                high=mid-1;
            }else {
                low=mid+1;
            }
            mid=(low+high)/2;
        }


        return  foundIndex;
    }

}