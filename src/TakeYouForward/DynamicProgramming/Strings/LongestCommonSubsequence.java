package TakeYouForward.DynamicProgramming.Strings;


import java.util.Arrays;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(LCSHelperTabulation("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp= new int[text1.length()][text2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return  LCSHelperDP(text1,text2,0,0,dp);

//        return LCSHelper(text1, text2, 0, 0);
    }

    public static int LCSHelperTabulation(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int [][] dp= new int[text1.length()+1][text2.length()+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
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

    public static int LCSHelper(String text1, String text2, int i, int j) {
        int answer = 0;

        if (i >= text1.length() || j >= text2.length()) {
            return answer;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            answer = 1 + LCSHelper(text1, text2, i + 1, j + 1);
        } else {
            int left = LCSHelper(text1, text2, i + 1, j);
            int right = LCSHelper(text1, text2, i, j + 1);
            answer=Math.max(left,right);
        }
        return answer;
    }
}