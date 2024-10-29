package TakeYouForward.DynamicProgramming.Strings;

class LongestCommonSubString {
    public static void main(String[] args) {

        System.out.println(longestCommonSubstr("adac", "adadac"));
    }

    public static int longestCommonSubstr(String str1, String str2) {
        int answer = 0;
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    answer=Math.max(dp[i][j],answer);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return answer;
    }
}