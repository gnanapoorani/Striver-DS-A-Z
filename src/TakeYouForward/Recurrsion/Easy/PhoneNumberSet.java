package TakeYouForward.Recurrsion.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PowerImpl232ds {
    public static void main(String[] args) {

//        System.out.println(phoneNumber("", "12"));
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(wordSearchExist(board, "ABCCED"));
        List<String> wordDict=new ArrayList<>();
        wordDict.add("car");
        wordDict.add("rs");
        wordDict.add("ca");
        System.out.println("wordBreak"+wordBreak("cars", wordDict));

    }

    public static ArrayList<String> phoneNumber(String Processed, String S) {
        ArrayList<String> answer = new ArrayList<>();
        if (S.isEmpty()) {
            answer.add(Processed);
            return answer;
        }
        int digit = S.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            answer.addAll(phoneNumber(Processed + ch, S.substring(1)));
        }
        return answer;
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinationsHelper(digits, 0,result, "");
        return result;
    }

    public void letterCombinationsHelper(String digits, int index, List<String> result, String prefix) {

        if (index > digits.length()) {
            result.add(prefix);
            return;
        }
        String word = KEYS[digits.charAt(index) - '0'];

        for (int i = 0; i < word.length(); i++) {
            letterCombinationsHelper(digits, index + 1, result, prefix + word.charAt(i));
        }
    }

    public static boolean wordSearchExist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]== word.charAt(0)){
                    if(existHelper(board,word,0,0,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean existHelper(char[][] board, String word, int row, int column, int index) {

        if (index==word.length()) {
            return true;
        }

        if(row <0 || column <0 || row > board.length || column > board[0].length
                || board[row][column]!=word.charAt(index)
                || board[row][column] == '!'){
            return false;
        }

        char c = board[row][column];
        board[row][column] = '!';


        /**right */
        boolean right=existHelper(board, word, row, column+1, index+1);
        /**left */
       boolean left= existHelper(board, word, row, column-1, index+1);
        /**down */
        boolean down=existHelper(board, word, row+1, column, index+1);
        /**up*/
        boolean up=existHelper(board, word, row-1, column, index+1);

        board[row][column]=c;
        return right || left || down || up;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
        int[][] matrix=new int[n][n];
        solveNQueensHelper(n,matrix);
        return result;
    }

    public static void solveNQueensHelper(int n,int[][] matrix) {

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        int[] dp=new int[s.length()+1];
        return wordBreakHelper(0,s,set,dp);
    }

    public static boolean wordBreakHelper(int start,String s, Set<String> set,int[] dp) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int end = start; end <= len; ++end) {
            if (set.contains(s.substring(0, end)) && wordBreakHelper(end,s.substring(end+1), set,dp)) {
                return true;
            }
        }
        return false;
    }
}