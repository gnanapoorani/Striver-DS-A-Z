package TakeYouForward.DynamicProgramming.Strings;


import java.util.Arrays;

class DistinctSubSequence {
    public static void main(String[] args) {
        System.out.println(
                numDistinct("bagg", "bag"));
        System.out.println(
                numDistinctTabulation("bagg", "bag"));
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return numDistinctHelperDP(s, t, 0,0, dp, "");
    }

    public static int numDistinctTabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            dp[i][0] = 1;
        }
        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int take=0;
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    take = dp[ i - 1][j-1];
                }
                int notTake = dp[i - 1][j];
                dp[i][j] = take + notTake;
            }
        }
        return dp[m][n];
    }

    public static int numDistinctHelperDP(String text1, String text2, int i,int j, int[][] dp, String s) {
        int count = 0;
        if (text2.equals(s)) {
            return 1;
        }
        if (i >= text1.length() || j>= text2.length()) {// babgbag
            return count;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            take = numDistinctHelperDP(text1, text2, i + 1, j+1, dp, s + text1.charAt(i));
        }
        int notTake = numDistinctHelperDP(text1, text2, i + 1,j, dp, s );
        dp[i][j]=count = take + notTake;
        return count;
    }
}