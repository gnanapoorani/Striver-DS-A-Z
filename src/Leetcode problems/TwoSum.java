
import java.util.Map;
import java.util.HashMap;

class TwoSum {
    public static void main(String[] args) {

        int arr[]= {3,8,5,2,1};
        int target=10;
        int result[]=twoSum(arr,target);
        System.out.println(result[0]+""+result[1]);

    }
    public static int[] twoSum(int[] nums, int target) {

        final int[] result = new int[2];
        final Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            final int first = nums[i];
            final int diff = target - first;

            final Integer second = numberToIndex.get(diff);
            
            if (second != null) {
                result[0] = second;
                result[1] = i;
                return result;
            }

            numberToIndex.put(first, i);

        }
        return result;
    }
}