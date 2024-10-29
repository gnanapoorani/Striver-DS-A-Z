class MissingNumberXOR{
    public static void main(String[] args){
        int a[] = {1,0};
        System.out.println(missingNumber(a));

    }

    public static int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber1(int[] nums) {
        int n=nums.length;
        int totalsum=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        return totalsum-sum;
    }
}