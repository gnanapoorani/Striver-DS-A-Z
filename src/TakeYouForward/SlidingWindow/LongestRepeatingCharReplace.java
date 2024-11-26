package TakeYouForward.SlidingWindow;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class LongestRepeatingCharReplace {

    public static void main(String[] args) {
        System.out.println((characterReplacement("AABABBA", 2)));
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

}