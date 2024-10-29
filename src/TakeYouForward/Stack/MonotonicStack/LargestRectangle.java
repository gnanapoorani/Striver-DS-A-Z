package TakeYouForward.Stack.MonotonicStack;

import javafx.util.Pair;

import java.util.Stack;

class LargestRectangle {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
//        System.out.println("largestRectangleArea" + largestRectangleArea(heights));
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix1 = {{ '0', '1'}, {'1', '0'}};
        System.out.println("maximalRectangle" + maximalRectangle(matrix1));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair<Integer, Integer>> st_PLE = new Stack<>();
        Stack<Pair<Integer, Integer>> st_NLE = new Stack<>();
        int[] PLE = new int[n];
        int[] NLE = new int[n];
        /**PLE*/
        for (int i = 0; i < n; i++) {
            while (!st_PLE.isEmpty() && st_PLE.peek().getKey() >= heights[i]) {
                st_PLE.pop();
            }
            PLE[i] = (!st_PLE.isEmpty()) ? i - st_PLE.peek().getValue() : i + 1;
            st_PLE.push(new Pair<>(heights[i], i));
        }

        /**NLE*/
        for (int i = n - 1; i >= 0; i--) {
            while (!st_NLE.isEmpty() && st_NLE.peek().getKey() > heights[i]) {
                st_NLE.pop();
            }
            NLE[i] = (!st_NLE.isEmpty()) ? st_NLE.peek().getValue() - i : n - i;
            st_NLE.push(new Pair<>(heights[i], i));
        }

        int maxArea = 0;
        for (int k = 0; k < heights.length; k++) {
            maxArea = Math.max(maxArea, heights[k] * (NLE[k] + PLE[k] - 1));
        }
        return maxArea;
    }


    public static int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]-'0' == 0) {
                    heights[j] = 0;
                } else {
                    int ele=matrix[i][j]-'0';
                    heights[j] = heights[j] + ele;
                }
            }
            maxArea=Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
}