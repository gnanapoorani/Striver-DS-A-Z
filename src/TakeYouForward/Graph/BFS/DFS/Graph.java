package TakeYouForward.Graph.BFS.DFS;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        mainList.add(0, new ArrayList<>());
        mainList.add(1, new ArrayList<>());
        mainList.add(2, new ArrayList<>());
        mainList.add(3, new ArrayList<>());
        mainList.add(4, new ArrayList<>());
        mainList.get(0).add(0);
        mainList.get(0).add(1);
        mainList.get(1).add(1);
        mainList.get(1).add(2);
        mainList.get(2).add(3);
        mainList.get(2).add(4);
        System.out.println("    dfsOfGraph(); " + dfsOfGraph(5, mainList));
        System.out.println("    detectCycle(); " + detectCycle(5, mainList));
        System.out.println("    bfsOfGraph(); " + bfsOfGraph(5, mainList));
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("    updateMatrix(); " + updateMatrixBFS(grid));
        System.out.println("    updateMatrix DFS(); " + updateMatrixDFS(grid));
        System.out.println(" rotten oranges " + orangesRottingBFS(grid));
        System.out.println("    ladderLength(); " +
                ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log","cog")));
    }


    static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V + 1];
        for (int j = 0; j < adj.size(); j++) {
            boolean cycleFlag = true;
            for (int i : adj.get(j)) {
                if (!visited[i]) {
                    cycleFlag = false;
                    visited[i] = true;
                }
            }
            if (cycleFlag) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V + 1];
        ArrayList<Integer> result = new ArrayList<>();
        visited[0] = true;
        return dfsRecursive(0, adj, result, visited);
    }

    public static ArrayList<Integer> dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, boolean visited[]) {
        result.add(node);
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfsRecursive(i, adj, result, visited);
            }
        }
        return result;
    }

    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        vis[0] = true;
        q.add(0);

        while (q.size() != 0) {
            int node = q.poll();
            bfs.add(node);
            for (Integer it : adj.get(node)) {
                if (vis[it] != true) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }



    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int[][] floodFill(int[][] image, int i, int j, int color) {
       return floodFill(image,i,j,image[i][j],color);
    }
    public int[][] floodFill(int[][] image, int i, int j, int color,int newColor) {
        if (i >= 0 && j < image[0].length && i < image.length && j >= 0) {
            image[i][j] = color;
            floodFill(image, i + 1, j, color); // down
            floodFill(image, i - 1, j, color); // up
            floodFill(image, i, j + 1, color); // left
            floodFill(image, i, j - 1, color); // right
        }
        return image;
    }
    /**
     * DFS way
     * https://leetcode.com/problems/rotting-oranges/solutions/602284/java-dfs-beats-100/
     */
    public static int orangesRottingDFS(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        ArrayList<Integer[]> rotten = new ArrayList<>();
        int[] max = new int[1];
        max[0] = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdjacent(grid, i, j, 2, max);
                }
            }
        }
        int minutes = 2;
        for (int row[] : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes - 2;
    }

    public static void rotAdjacent(int[][] grid, int i, int j, int minutes, int[] max) {

        if (i < 0 || j >= grid[0].length ||
                i >= grid.length || j < 0 ||
                grid[i][j] == 0 || grid[i][j] > 1 && grid[i][j] < minutes) {
            return;
        }
        if (max[0] < minutes) {
            max[0] = minutes;
        }
        grid[i][j] = minutes;
        rotAdjacent(grid, i + 1, j, minutes + 1, max); // down
        rotAdjacent(grid, i - 1, j, minutes + 1, max); // up
        rotAdjacent(grid, i, j + 1, minutes + 1, max); // left
        rotAdjacent(grid, i, j - 1, minutes + 1, max); // right
        return;
    }

    /**
     * BFS way
     * https://leetcode.com/problems/rotting-oranges/solutions/602284/java-dfs-beats-100/
     */

    public static int orangesRottingBFS(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int countFreshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    countFreshOranges++;
                }
            }
        }

        int minutes = -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
                while (size > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && j >= 0  && i < m && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        countFreshOranges--;
                        queue.offer(new int[]{i, j});
                    }
                }
                size--;
            }
            minutes++;
        }
        if(countFreshOranges ==0){
            return minutes;
        }
        return -1;
    }

    /**
     * DFS is Not a  good approach for this sum, TLE is showing..so go for BFS
     */
    public static int[][] updateMatrixDFS(int[][] mat) {
        int[][] upd = mat;
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (upd[i][j] == 1) {
                    dp[i][j] = 1;
                    upd[i][j] = calculateDistance(mat, i, j, 0, dp);
                    dp[i][j] = 0;
                }
            }
        }
        return upd;
    }


    public static int calculateDistance(int[][] grid, int x, int y, int distance, int[][] dp) {

        int up = 1000, down = 1000, left = 1000, right = 1000;
        if (grid[x][y] == 0) {
            return distance;
        }
        if (x > 0) {//up
            if (dp[x - 1][y] != 1) {
                dp[x - 1][y] = 1;
                up = calculateDistance(grid, x - 1, y, distance + 1, dp);
                dp[x - 1][y] = 0;
            }
        }
        if (y > 0) {//left
            if (dp[x][y - 1] != 1) {
                dp[x][y - 1] = 1;
                left = calculateDistance(grid, x, y - 1, distance + 1, dp);
                dp[x][y - 1] = 0;
            }
        }
        if ((up != 1 || left != 1) & x < grid.length - 1) {//down
            if (dp[x + 1][y] != 1) {
                dp[x + 1][y] = 1;
                down = calculateDistance(grid, x + 1, y, distance + 1, dp);
                dp[x + 1][y] = 0;
            }
        }
        if (y < grid.length - 1) {//right
            if (dp[x][y + 1] != 1) {
                dp[x][y + 1] = 1;
                right = calculateDistance(grid, x, y + 1, distance + 1, dp);
                dp[x][y + 1] = 0;
            }
        }
        return Math.min(Math.min(up, down), Math.min(left, right));
    }

    public static int[][] updateMatrixBFS(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    matrix[i][j] = -1;
            }
        }
        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r < 0 || c < 0 || r == matrix.length || c == matrix[0].length || matrix[r][c] != -1) continue;
                    matrix[r][c] = length;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }

    public static void solve(char[][] board) {
        /** Boundary check - Frist row and lost row*/
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfsSurrondingRegion(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfsSurrondingRegion(board, row-1, i);
            }
        }
        /** Boundary check - Frist column and lost column*/
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfsSurrondingRegion(board, i, 0);
            }
            if (board[i][col-1] == 'O') {
                dfsSurrondingRegion(board,i,col-1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '@') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    static void dfsSurrondingRegion(char[][] grid, int i, int j) {
        /** Base condition*/
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='O'){
            return;
        }
        grid[i][j]='@';
        dfsSurrondingRegion(grid,i+1,j);//down
        dfsSurrondingRegion(grid,i-1,j);//up
        dfsSurrondingRegion(grid,i,j-1); //left
        dfsSurrondingRegion(grid,i,j+1);//right
        return;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord) && wordSet.contains(newWord)) {
                            return level + 1;
                        }
                        if (!word.equals(newWord) && wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
