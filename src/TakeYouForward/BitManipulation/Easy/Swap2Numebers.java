package TakeYouForward.BitManipulation.Easy;

import java.util.List;
import java.util.ArrayList;

class Swap2Numebers {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(divide(-2147483648, -1));
        int nums[] = {5, 5, 5, 7};
        System.out.println(singleNumber2(nums));

    }

    /**
     * Minimum Bit flips to convert a number
     */
    public static int minBitFlips(int start, int goal) {
//        return Integer.bitCount(start^goal);
        int answer = start ^ goal;
        int count = 0;
//        while (answer > 1) {
//            if (answer % 2 == 1) {
//                count++;
//            }
//            answer = answer >> 1;
//        }
//        if (answer == 1) {
//            count++;
//        }
        while (answer > 0) {
            count++;
            answer = answer & (answer - 1);
        }
        return count;
    }

    static List<Integer> swap2NumbersUsingBit(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        List<Integer> answer = new ArrayList<>();
        answer.add(a);
        answer.add(b);
        return answer;
    }

    /**
     * Power Set
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int b = 0; b < 1 << nums.length; b++) {
                if (((i >> b) & 1) == 1) {
                    subSet.add(nums[b]);
                }
            }
            result.add(subSet);
        }
        return result;
    }

    /**
     * single Number 1
     * Number appearing twice or odd number of times
     */
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }
        return answer;
    }

    /**
     * single Number 2
     * Given an integer array nums
     * where every element appears three times except for one,
     * which appears exactly once. Find the single element and return it.
     */
    public static int singleNumber2(int[] nums) {
/**
 * Great solution- please mug up
 * https://leetcode.com/problems/single-number-ii/solutions/3714928/bit-manipulation-c-java-python-beginner-friendly/
 */
//        int ones = 0;
//        int twos = 0;
//
//        for (final int num : nums) {
//            ones ^= (num & ~twos);
//            twos ^= (num & ~ones);
//        }
//
//        return ones;


        int result = 0;
        int result2 = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int count2 = 0;
            for (int b = 0; b < nums.length; b++) {
                count += (nums[b] & (1 << i));//wrong
                count2 += nums[b] >> i & 1; //correct
            }
            count %= 3;
            count2 %= 3;
            result |= count << i;
            result2 |= count2 << i;
        }
        return result;
    }

    /**
     * single Number 3
     * Given an integer array nums,
     * in which exactly two elements appear only once and all the other elements appear exactly twice.
     * Find the two elements that appear only once. You can return the answer in any order.
     */
    public int[] singleNumber3(int[] nums) {
        int result[] = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int bit = xor & (~(xor - 1));

        int bucket1 = 0;
        int bucket2 = 0;

        for (int num : nums) {
            if ((num & bit) > 0) {
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }
        result[0]=bucket1;
        result[1]=bucket2;
        return result;
    }

    /**
     * Divide two integers without using multiplication, division, and mod operator.
     */
    public static int divide(int dividend, int divisor) {
        int answer = 0;
        int sign = 1;
        if (dividend < 0 && divisor > 0) {
            sign = -1;
        }
        if (dividend > 0 && divisor < 0) {
            sign = -1;
        }
        long d = Math.abs(divisor);
        long n = Math.abs(dividend);
        if (n == d) {
            return sign * 1;
        }
        while (d <= n) {

            int count = 0;
            while ((d << (count + 1)) <= n) {
                count++;
            }
            n -= (d << (count));
            answer += 1 << (count);
        }

        return (answer > Integer.MAX_VALUE) ? Integer.MAX_VALUE : answer < Integer.MIN_VALUE ? Integer.MIN_VALUE : sign * answer;
    }

    public static int xorInRange(int n) {
        // Check if n is
        // congruent to 1 modulo 4
        if (n % 4 == 1) {
            return 1;
        }
        // Check if n is congruent
        // to 2 modulo 4
        else if (n % 4 == 2) {
            return n + 1;
        }
        // Check if n is
        // congruent to 3 modulo 4
        else if (n % 4 == 3) {
            return 0;
        }
        // Return condition
        // when n is a multiple
        else {
            return n;
        }
    }

    public static int findXOR(int l, int r) {
        int XORTillL = xorInRange(l - 1);
        int XORTillR = xorInRange(r);
        return XORTillR ^ XORTillL;
    }
}