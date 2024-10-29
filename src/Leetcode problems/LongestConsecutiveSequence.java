
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int nums[] = {0,1,1,2};
        Arrays.sort(nums);
        System.out.println(findLongestConsecutiveSequence(nums));


    }

    public static int findLongestConsecutiveSequence(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int maxSequence = -1, counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                counter++;
            } else if(nums[i] == nums[i - 1]){
                continue;
            }else{
                counter=1;
            }
            if (maxSequence < counter) {
                maxSequence = counter;
            }
        }
        return maxSequence;
    }
}