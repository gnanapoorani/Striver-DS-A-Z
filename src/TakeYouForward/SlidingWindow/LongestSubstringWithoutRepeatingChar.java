package TakeYouForward.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxCounter = 0, n = s.length(), cnt = 0;
        Set<Character> set = new HashSet<>();
        while (right < n) {
            if (set.add(s.charAt(right))) {
                right++;
                cnt++;
            } else {
                set.remove(s.charAt(left));
                left++;
                cnt--;
            }
            maxCounter = Math.max(maxCounter, cnt);
        }
        return maxCounter;
    }

    /**
     * This method using hashmap is also very nice
     * Refer striver notes
     */
    static int solve(String s) {
        HashMap< Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}