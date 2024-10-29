package TakeYouForward.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

class MinimumPathSumTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i < 0; i++) {
            int k = triangle.get(i).size();
            for (int j = 0; j < k; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static int minimumTotalGoodSolution(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

}