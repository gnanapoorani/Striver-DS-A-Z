import java.util.ArrayList;
import java.util.List;

class SetZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix1 ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix1);
    }

    public static void setZeroes(int[][] matrix) {
        // Lists to store the indices of rows and columns containing zero elements
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList();

        // Iterate through the matrix to find the zero elements and store their indices
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        // Iterate through the matrix again and set elements in rows and columns with zero elements to zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        // The function returns void (no specific return value is needed)
        return;
    }
    public static void setZeroesWorst(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = -99999;
                    matrix[i][0] = -99999;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0]==-99999){
                for(int k=0;k<n;k++){
                    if(matrix[i][k]!=-99999){
                        matrix[i][k]=0;
                    }
                }
//                matrix[i][0]=0;
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[0][i]==-99999){
                for(int k=0;k<m;k++){
                    if(matrix[k][i]!=-99999){
                        matrix[k][i]=0;
                    }
                }
            //    matrix[0][i]=0;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0]==-99999){
                matrix[i][0]=0;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==-99999){
                matrix[0][i]=0;
            }
        }
    }
}