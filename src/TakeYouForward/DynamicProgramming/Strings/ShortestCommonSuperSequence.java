package TakeYouForward.DynamicProgramming.Strings;


import java.util.Arrays;

class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        System.out.println(
                shortestCommonSupersequence("abac", "cab"));
    }

    public static String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        LCSHelperDP(text1, text2, 0, 0, dp);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        LCSHelperTabulation(text1, text2, dp);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int i = m, j = n;
        StringBuilder str = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                str.append(text1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // Move upwards
                str.append(text1.charAt(i - 1));
                i--;
            } else {
                str.append(text2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            str.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str.append(text2.charAt(j - 1));
            j--;
        }
        String answer = str.reverse().toString();
        return answer;
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


    public static int LCSHelperDP(String text1, String text2, int i, int j, int[][] dp) {
        int answer = 0;

        if (i >= text1.length() || j >= text2.length()) {
            return answer;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = answer = 1 + LCSHelperDP(text1, text2, i + 1, j + 1, dp);
        } else {
            int left = LCSHelperDP(text1, text2, i + 1, j, dp);
            int right = LCSHelperDP(text1, text2, i, j + 1, dp);
            dp[i][j] = answer = Math.max(left, right);
        }
        return answer;
    }
}