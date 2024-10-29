class LowerBound{
    public  static void main(String[] args){
        int[] nums={1,2,2,3,5};
        System.out.println(search(nums,2));
    }
    public static int search(int[] nums, int target) {

        int lowerBound=nums.length;
        int low=0,high=nums.length,mid=nums.length/2;
       while(low<=high){
           mid=low+high/2;
           if(mid>=target){
               high=mid-1;
               lowerBound=mid;
           }else{
               low=mid+1;
           }
       }
       return lowerBound;
    }

}