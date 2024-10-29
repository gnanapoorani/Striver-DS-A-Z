package TakeYouForward.DynamicProgramming.Strings;

import java.util.*;

class PrintAllLCS {
    public static void main(String[] args) {
        System.out.println(all_longest_common_subsequences("brute", "groot"));
    }

    public static List<String> all_longest_common_subsequences(String s, String t) {
        Set<String> resultSt = new HashSet<>();
        Map<String,Boolean> memo = new HashMap<>();
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        LCSHelperTabulation(s, t, dp);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        backtrack(s, t, m, n, dp, resultSt, "",memo);
        List<String> stringList = new ArrayList<>(resultSt);
        Collections.sort(stringList);
        return stringList;
    }

    public static void backtrack(String text1, String text2, int i, int j, int[][] dp, Set<String> resultSet, String result,Map<String,Boolean> memo) {

        if (i <= 0 || j <= 0) {
            resultSet.add(new StringBuilder(result).reverse().toString());
            return;
        }
        String key = i + "," + j + "," + result;
        if (memo.containsKey(key)) return;  // Skip already computed states
        memo.put(key, true);

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            backtrack(text1, text2, i - 1, j - 1, dp, resultSet, result + text1.charAt(i - 1),memo);
        } else {
            if (dp[i - 1][j] == dp[i][j]) {
                backtrack(text1, text2, i - 1, j, dp, resultSet, result,memo);
            }
            if (dp[i][j - 1] == dp[i][j]) {
                backtrack(text1, text2, i, j - 1, dp, resultSet, result,memo);
            }
        }
    }

    public static int LCSHelperTabulation(String text1, String text2, int[][] dp) {
        int m = text1.length();
        int n = text2.length();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}