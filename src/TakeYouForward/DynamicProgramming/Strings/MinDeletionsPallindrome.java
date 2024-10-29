package TakeYouForward.DynamicProgramming.Strings;

import java.util.Arrays;

class MinDeletionsPallindrome {
    public static void main(String[] args) {
        System.out.println(minDistance("leetcode","etco"));
    }

    /**
     * Minimum Insertion/Deletions required = n(length of the string) - length of longest palindromic subsequence.
     */
    public static int minDistance(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();
        int[][] dp= new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
       int commonPortion= LCSHelperDP(word1,word2,0,0,dp);
        return  (m+n - 2*(commonPortion));
    }

    public static int LCSHelperDP(String text1, String text2, int i, int j,int[][] dp) {
        int answer = 0;

        if (i >= text1.length() || j >= text2.length()) {
            return answer;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j]=answer = 1 + LCSHelperDP(text1, text2, i + 1, j + 1,dp);
        } else {
            int left = LCSHelperDP(text1, text2, i + 1, j,dp);
            int right = LCSHelperDP(text1, text2, i, j + 1,dp);
            dp[i][j]=answer=Math.max(left,right);
        }
        return answer;
    }
}