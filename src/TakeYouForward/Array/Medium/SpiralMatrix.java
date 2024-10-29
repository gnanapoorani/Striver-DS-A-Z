import java.util.ArrayList;
import java.util.List;

class SetZeroMatrixnew {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{1,0,1},{1,1,1}};
        int[][] matrix1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(spiralOrder(matrix1));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            /** Left to Right Traversal* */
            for (int i = left; i <= right; i++) {
                answer.add(matrix[left][i]);
            }
            top++;
            /** Top to Bottom Traversal* */
            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;

            /** Right to Left Traversal* */
            if(top<=bottom){
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            /** Bottom to Top Traversal* */
            if(left<=right){
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++;
            }


        }
        return answer;
    }
}