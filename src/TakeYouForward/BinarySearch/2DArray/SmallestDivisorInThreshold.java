import java.util.Arrays;

class SmallestDivisorInThreshold {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int answer = 0;
        int low = 1, high = Arrays.stream(nums).max().getAsInt(), mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int result = calculateDivisionSum(nums, mid);
            if (result <= threshold) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;

    }

    private static int calculateDivisionSum(int[] nums, int divisor) {
        int total = 0;
        for(int num : nums) {
            total += (num + divisor - 1) / divisor;
        }

        return total;
    }
}