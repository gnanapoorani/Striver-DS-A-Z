//Largest Sum Contiguous Subarray (Kadane’s Algorithm)
class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int answer = Integer.MAX_VALUE, maxSoFar = 0;
        for (int num : nums) {
            maxSoFar = maxSoFar + num;
            answer = Math.max(answer, maxSoFar);
            maxSoFar = Math.max(maxSoFar, 0);
        }
        return answer;
    }
}