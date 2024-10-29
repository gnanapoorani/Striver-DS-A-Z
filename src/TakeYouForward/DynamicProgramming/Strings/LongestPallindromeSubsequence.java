package TakeYouForward.DynamicProgramming.Strings;

import java.util.Arrays;

class LongestPallindromeSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseqTabulation("cbbd"));
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return LPSHelperDP(s,0,s.length()-1,dp);
    }

    public static int longestPalindromeSubseqTabulation(String s) {
        int m=s.length();
        String s2=new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=2+ dp[ i - 1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[ i - 1][ j],dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }

    public static int LPSHelperDP(String text1, int i, int j,int[][] dp) {
        int answer = 0;

        if (i == j) { //middle one last element
            return 1;
        }
        if(j<i){
            return 0;
        }
        if(dp[i][j]!=-1){
           return dp[i][j];
        }
        if (text1.charAt(i) == text1.charAt(j)) {
            dp[i][j]=answer = 2 + LPSHelperDP(text1, i + 1, j - 1,dp);
        } else {
            int left = LPSHelperDP(text1, i + 1, j,dp);
            int right = LPSHelperDP(text1, i, j - 1,dp);
            dp[i][j]=answer=Math.max(left,right);
        }
        return answer;
    }
}