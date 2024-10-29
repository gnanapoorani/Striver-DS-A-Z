class SingleNumber{
    public static void main(String[] args){
        int nums[]={2,1,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
int answer=0;
for(int i=0;i<nums.length;i++){
    answer =answer^nums[i];
}
return  answer;
    }

}