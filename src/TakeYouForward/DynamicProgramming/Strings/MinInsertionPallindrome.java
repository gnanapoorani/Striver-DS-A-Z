package TakeYouForward.DynamicProgramming.Strings;

class MinInsertionPallindrome {
    public static void main(String[] args) {
        System.out.println(minInsertions1("zjveiiwvc"));
        System.out.println(minInsertions("zjveiiwvc"));
    }
    /**
     * Minimum Insertion/Deletions required = n(length of the string) - length of longest palindromic subsequence.
     */
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        return lcs(s, 0, n - 1,memo);
    }

    private static int lcs(String s, int left, int right,int[][] memo) {

        if (left >= right)
            return 0;

        if (memo[left][right] != 0)
            return memo[left][right];

        if (s.charAt(left) == s.charAt(right))
            return memo[left][right] = lcs(s, left + 1, right - 1,memo);

        return memo[left][right] = 1 + Math.min(lcs(s, left + 1, right,memo), lcs(s, left, right - 1,memo));
    }

    public static int minInsertions1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        System.out.println( minInsertionsHelper(s, 0, s.length() - 1, 0));
        return minInsertionsHelper(s, 0, s.length() - 1, 0, dp);

    }

    public static int minInsertionsHelper(String text1, int i, int j,int count) {
        int answer = 0;

        if (i>= j) { //middle one last element
            return count;
        }
        if (text1.charAt(i) == text1.charAt(j)) {
            answer=  minInsertionsHelper(text1, i + 1, j - 1,count);
        } else {
            int left=minInsertionsHelper(text1, i + 1, j ,count+1);
            int right=minInsertionsHelper(text1, i , j-1 ,count+1);
            answer=Math.min(left,right);
        }
        return answer;
    }

    public static int minInsertionsHelper(String text1, int i, int j, int count, int[][] dp) {
        int answer = 0;

        if (i >= j) { //middle one last element
            return count;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text1.charAt(j)) {
            dp[i][j] = answer = minInsertionsHelper(text1, i + 1, j - 1, count, dp);
        } else {
            int left = minInsertionsHelper(text1, i + 1, j, count + 1, dp);
            int right = minInsertionsHelper(text1, i, j - 1, count + 1, dp);
            dp[i][j] = answer = Math.min(left, right);
        }
        return answer;
    }
}