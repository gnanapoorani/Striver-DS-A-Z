class FirstAndLastOccurrence{
    public  static void main(String[] args){
        int[] nums={5,7,7,8,8,10};
        int[] ans = searchRange(nums, 6);
        System.out.println("The first and last positions are: "
                + ans[0] + " " + ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] answer=new int[2];
        answer[0]=findFirst(nums,target);
        if(answer[0]==-1){
            answer[1]=-1;
            return answer;
        }
        answer[1]=findLast(nums,target,answer[0]);
        return answer;
    }
    public static int findFirst(int[] nums, int target) {

        int firstOccurence=-1;
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                high=mid-1;
                firstOccurence=mid;
            }
        }
        return firstOccurence;
    }

    public static int findLast(int[] nums, int target,int low) {

        int lastOccurrence=nums.length-1;
        int high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
            }else{
                lastOccurrence=mid;
                low=mid+1;
            }
        }
        return lastOccurrence;
    }

}