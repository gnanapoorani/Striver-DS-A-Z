package TakeYouForward.Greedy;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class JUMP2 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 3, 4, 6, 1, 4};
        System.out.println(jump(nums));
    }


    public static int jump(int[] nums) {
        return jumpHelper(nums, 0,0);
    }

    public static int jumpHelper(int[] nums, int index,int jump) {
        int min=Integer.MAX_VALUE;
        if(index==nums.length-1){
            return jump;
        }
        for (int i = 1; i <= nums[index]; i++) {
            min=Integer.min(jumpHelper(nums, index + i,jump+1),min);
        }
        return min;
    }
}