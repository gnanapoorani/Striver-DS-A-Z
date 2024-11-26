package TakeYouForward.Array.Easy;

import java.util.Arrays;

class CheckSortedAndRotated {
    public static void main(String[] args) {
        int num[] = {2,1,3,4};
//        int num[]={1,2,3,4,5,};
        System.out.println(BestSolution(num));
    }

    public static boolean BestSolution(int[] nums) {

        int count =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                //point of deflection
                count++;
            }

        }
        if(nums[0] < nums[nums.length-1])
            count++;

        return count<=1;
    }

    public static boolean check(int[] nums) {
        int newArray[] = new int[nums.length];
        int i = 0;
        while (i < nums.length - 1 && nums[i] <=nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1) {
            return true;
        } else {
            int j = i + 1;
            int k = 0;
            while (j < nums.length) {
                newArray[k] = nums[j];
                k++;
                j++;
            }
            j = 0;
            while (j <= i) {
                newArray[k] = nums[j];
                k++;
                j++;
            }
            Arrays.sort(nums);
            return Arrays.equals(nums, newArray);
        }
    }
}