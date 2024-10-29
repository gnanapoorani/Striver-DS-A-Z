class MoveZeroes{
    public static void main(String[] args){
        int[] nums = {0,0,1};
        moveZeroes(nums);
    }

    public static  void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for(int num:nums){
            if(num !=0){
                nums[writeIndex++]= num;
            }
        }
        while(writeIndex<nums.length){
            nums[writeIndex++] = 0;
        }
    }

}