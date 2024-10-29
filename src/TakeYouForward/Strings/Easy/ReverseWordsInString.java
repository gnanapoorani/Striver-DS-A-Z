import java.util.Stack;
import java.util.StringTokenizer;

class ReverseWordsInString {
    public static void main(String[] args) {

        System.out.println(reverseWords("  hello     world  "));
    }

    public static String reverseWords1(String s) {
        s=s.trim();
        StringBuilder result = new StringBuilder();

        String[] words = s.split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if(i!=0){
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringTokenizer key = new StringTokenizer(s);
        while(key.hasMoreTokens()){
            st.push(key.nextToken());
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop()).append(" ");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

}