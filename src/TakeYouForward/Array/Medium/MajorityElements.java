import java.util.HashMap;

class MajorityElements{
    public  static void main(String[] args){
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {

        int target= nums.length/2;
        HashMap<Integer,Integer> mp=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
if(mp.get(nums[i])!=null){
    int frequency=mp.get(nums[i])+1;
    if(frequency>target){
        return nums[i];
    }
    mp.put(nums[i],frequency);
}else{
    mp.put(nums[i],1);
}
        }
return 0;
    }
}