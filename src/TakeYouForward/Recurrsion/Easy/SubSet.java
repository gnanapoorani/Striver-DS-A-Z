package TakeYouForward.Recurrsion.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PowerImp12l {
    static List<List<Integer>> answer = new ArrayList<>();
    static List<List<Integer>> combination2Answer = new ArrayList<>();
    public static void main(String[] args) {

//        System.out.println(subset("", "123"));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2, 3}));
        System.out.println("perfectSum count : " + perfectSum(new int[]{1, 0}, 2, 1));
        combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println("combinationSum : " + answer);
        combinationSum2(new int[]{2, 3, 5}, 8);
        System.out.println("combinationSum2 : " + combination2Answer);

    }

    public static ArrayList subset(String Processed, String S) {
        ArrayList<String> answer = new ArrayList<>();
        if (S.isEmpty()) {
            answer.add(Processed);
            return answer;
        }
        answer.addAll(subset(Processed + S.charAt(0), S.substring(1)));
        answer.addAll(subset(Processed, S.substring(1)));
        return answer;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        return subsetsWithDup(nums, 0, new ArrayList<>());
    }

    public static List<List<Integer>> subsetsWithDupIteration(int[] numsr) {
        List<List<Integer>> outer = new ArrayList<>();


        return outer;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums, int i, ArrayList<Integer> subAnswer) {
        List<List<Integer>> answer = new ArrayList<>();
        if (i > nums.length - 1) {
            answer.add(subAnswer);
            return answer;
        }
        ArrayList<Integer> subAnswer2 = new ArrayList<>();
        subAnswer2.addAll(subAnswer);
        subAnswer2.add(nums[i]);
        answer.addAll(subsetsWithDup(nums, i + 1, subAnswer2));
        ArrayList<Integer> subAnswer1 = subAnswer;
        answer.addAll(subsetsWithDup(nums, i + 1, subAnswer1));

        return answer;
    }

    public static int perfectSum(int arr[], int n, int sum) {
        return perfectSumHelper(arr, n, sum, 0, 0);

    }

    public static int perfectSumHelper(int arr[], int n, int sum, int index, int currentSum) {
        if (index == n) {
            if (currentSum == sum) {
                return 1;
            }
            return 0;
        }
        if (currentSum == sum) {
            return 1;
        }
        if (currentSum > sum) {
            return 0;
        }
        int take = perfectSumHelper(arr, n, sum, index + 1, currentSum + arr[index]);
        int notTake = perfectSumHelper(arr, n, sum, index + 1, currentSum);

        return take + notTake;
    }

    public static void combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, 0,new ArrayList<>());
    }

    public static void combinationSumHelper(int[] candidates, int target, int index, int currentSum,  List<Integer> subAnswer) {
        if (currentSum == target) {
            answer.add(subAnswer);
            return;
        }
        if (index >= candidates.length) {
            return ;
        }
        if (currentSum + candidates[index] <= target) {
            subAnswer.add(candidates[index]);
            currentSum += candidates[index];
            combinationSumHelper(candidates, target, index , currentSum,subAnswer);
            subAnswer.remove(subAnswer.size() - 1);
        }
        currentSum -= candidates[index];
        combinationSumHelper(candidates, target, index + 1, currentSum, subAnswer);
    }

    public static void combinationSum2(int[] candidates, int target) {
         combinationSum2Helper(candidates,target,new ArrayList<>(),0);
    }

    public static void  combinationSum2Helper(int[] candidates, int target,List<Integer> subAnswer,int index) {

        if(target==0){
            combination2Answer.add(subAnswer);
            return;
        }
        if(index >= candidates.length){
            return;
        }
        if(candidates[index]<target){
            subAnswer.add(candidates[index]);
            combinationSum2Helper(candidates,target-candidates[index],subAnswer,index+1);
            subAnswer.remove(subAnswer.size()-1);
        }
        combinationSum2Helper(candidates,target,subAnswer,index+1);

    }

}