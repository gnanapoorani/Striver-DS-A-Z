package TakeYouForward.SlidingWindow;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] nums = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        System.out.println(maxScoreIdeal(nums, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        return maxScore(cardPoints, 0, k, 0, cardPoints.length - 1);
    }

    public static int maxScoreIdeal(int[] cardPoints, int k) {
        int best = 0, total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }
        best = total;
        for (int i = k - 1, j = cardPoints.length - 1; i >= 0; i--, j--) {
            total += cardPoints[j] - cardPoints[i];
            best = Math.max(best, total);
        }
        return best;
    }

    public static int maxScore(int[] cardPoints, int answer, int count, int left, int right) {//9,7,7,9,7,7,9

        if (count == 0) {
            return answer;
        }
        int result = 0, result2 = 0, result1 = 0;
        if (left < cardPoints.length && left <= right) {
            result1 = maxScore(cardPoints, answer + cardPoints[left], count - 1, left + 1, right);
        }
        if (right >= 0 && left <= right) {
            result2 = maxScore(cardPoints, answer + cardPoints[right], count - 1, left, right - 1);

        }
        result = Math.max(result2, result1);
        return result;
    }
}