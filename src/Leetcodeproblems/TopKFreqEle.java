
import java.util.*;

class TopKFreqEleNew {
    public static void main(String[] args) {

        int nums[]= {-1,-1};
        int k=1;
        int result[]=topK(nums,k);
        System.out.println(result[0]);

    }
    public static int[] topK(int[] nums, int target) {

         Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(frequency.get(nums[i])==null){
                frequency.put(nums[i],1);
            }else{
                frequency.put(nums[i],frequency.get(nums[i])+1);
            }
        }
        if(nums.length>1){
            return sortByValue(frequency,target);
        }else{
            return nums;
        }

    }

    public static int[] sortByValue(Map<Integer, Integer> hm,int target)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
                = new LinkedList<Map.Entry<Integer, Integer> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(list, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));

        // put data from sorted list to hashmap
        int[] temp = new int[2];
        int i=0;
        for (Map.Entry<Integer, Integer> aa : list) {
            if(i<target){
                temp[i]=aa.getKey();
                i++;
            }else{
                break;
            }

        }
        return temp;
    }
}