package TakeYouForward.DynamicProgramming.Strings;


import java.util.Arrays;

class WildCardMatching {
    public static void main(String[] args) {
        System.out.println(
                wildcardMatching( "a*h","hch"));
//        System.out.println(
//                isMatchTabulation("intention", "execution"));
    }

    // Recursive function to perform wildcard pattern matching
    static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {


        // If the result is already computed, return it.
        if (dp[i][j] != -1) return dp[i][j];

        // If the characters match or S1 has a '?', continue matching the rest of the strings.
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

        else {
            if (S1.charAt(i) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches one or more characters in S2.
                // 2. '*' matches zero characters in S2.
                return dp[i][j] = (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 ||
                        wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            } else {
                // Characters don't match, and S1[i] is not '*'.
                return 0;
            }
        }
    }

    // Main function to check if S1 matches the wildcard pattern S2
    static int wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
    }

//    public static boolean isMatch1(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//        return isMatchDP(s, p, 0, 0, dp);
//    }

//    public static boolean isMatchDP(String text1, String text2, int i, int j, int[][] dp) {
//        int count = 0;
//        if (i >= text1.length()) {
//            return text2.length() - j;
//        }
//        if (j >= text2.length()) {
//            return text1.length() - i;
//        }
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        if (text1.charAt(i) == text2.charAt(j) || text1.charAt(i) == '?') {
//             isMatchDP(text1, text2, i + 1, j + 1, dp);
//        } else if (text1.charAt(i) == '*') {
//            isMatchDP(text1, text2, i + 1, j, dp);
//        } else {
//            return false;
//        }
//        dp[i][j] = count;
//        return count;
//    }

//    public static boolean isMatchTabulation(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        if (m < n) {
//            return 0;
//        }
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = i;
//        }
//        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = i;
//        }
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[m][n];
//    }
}