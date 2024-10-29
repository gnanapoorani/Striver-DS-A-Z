package TakeYouForward.DynamicProgramming.Strings;


import java.util.Arrays;

class EditDistance {
    public static void main(String[] args) {
        System.out.println(
                minDistance("intention", "execution"));
        System.out.println(
                minDistanceTabulation("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return minDistanceHelperDP(word1,word2,0,0,dp);
    }

    public static int minDistanceHelperDP(String text1, String text2, int i,int j, int[][] dp) {
        int count = 0;
        if (i>=text1.length()) {
            return text2.length()-j;
        }
        if (j>=text2.length()) {
            return text1.length()-i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            count = 0+minDistanceHelperDP(text1, text2, i + 1, j+1, dp);
        }else {
            count = 1+Math.min(Math.min(minDistanceHelperDP(text1, text2, i + 1, j+1, dp),
                    minDistanceHelperDP(text1, text2, i + 1, j, dp)),
                    minDistanceHelperDP(text1, text2, i , j+1, dp));
        }
        dp[i][j]=count ;
        return count;
    }

    public static int minDistanceTabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            dp[i][0] = i;
        }
        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}