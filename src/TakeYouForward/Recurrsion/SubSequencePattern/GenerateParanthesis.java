
import java.util.*;

class GenerateParanthesis {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        return generateParanthesisHelper(n, "", 0, 0);

    }

    public static List<String> generateParanthesisHelper(int N, String processed, int open, int close) {
        ArrayList<String> answer = new ArrayList<>();
        if (processed.length() == N * 2) {
            answer.add(processed);
            return answer;
        }

        if (open < N) {
            answer.addAll(generateParanthesisHelper(N, processed + "(", open + 1, close));
        }
        if (close < open) {
            answer.addAll(generateParanthesisHelper(N, processed + ")", open, close + 1));
        }
        return answer;
    }
}