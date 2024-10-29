
import java.util.*;

class GenerateAllBinaryString {
    public static void main(String[] args) {

        System.out.println(generateString(2));
    }

    public static List<String> generateString(int N) {
        return generateString(N, "", -1);
    }

    public static List<String> generateString(int N, String processed, int i) {
        ArrayList<String> answer = new ArrayList<>();
        if (N <1) {
             answer.add(processed);
             return  answer;
        }
        if (i == -1 || processed.charAt(i) - '0' == 0) {
            answer.addAll(generateString(N - 1, processed + "0", i + 1));
            answer.addAll(generateString(N - 1, processed + "1", i + 1));
        } else {
            answer.addAll(generateString(N - 1, processed + "0", i + 1));
        }

        return answer;
    }
}