
import java.util.*;

class TopKFreqEle {
    public static void main(String[] args) {

        int nums[]={10000,1,90,1};
        int k=2;
     topKFrequent(nums,2);

    }
    public static int[] topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {

            if (min > i) {
                min = i;
            }

            if (i > max) {
                max = i;
            }
        }

        int[] frequency = new int[max - min + 1];

        for (int num : nums) {
            frequency[num - min]++;
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        List<Integer> bucketList = new ArrayList<>(nums.length);

        for (int i = 0; i < 10; i++) {
            bucketList.add(0);
        }
        int maxFrequency = 0;
//        for (int i = 0; i < frequency.length; i++) {
//
//            if (frequency[i] > 0) {
//
//              //  if (bucketList.get(frequency[i])== null) {
//                    bucketList.set(frequency[i], i+min);
//                //}
//
//                maxFrequency = Math.max(frequency[i], maxFrequency);
//            }
//        }
        for (int i = 0; i < frequency.length; i++) {

            if (frequency[i] > 0) {

                if (buckets[frequency[i]] == null) {
                    buckets[frequency[i]] = new ArrayList<>();
                }

                buckets[frequency[i]].add(i + min);

                maxFrequency = Math.max(frequency[i], maxFrequency);
            }
        }

        int[] result = new int[k];

        for (int i = maxFrequency, index = 0; i > 0 && index < k; i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {

                    if (index == k) {
                        break;
                    }

                    result[index++] = num;
                }
            }
        }

        return result;
    }

}