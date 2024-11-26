package TakeYouForward.SlidingWindow;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 */
class NoOfSubstrAll3Char {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                count[s.charAt(i) - 'a']--;
                i++;
            }

            res += i;
        }
        return res;
    }

    public int numberOfSubstringsIdeal(String s) {
        int last[] = {-1, -1, -1}, res = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
            res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return res;
    }
}