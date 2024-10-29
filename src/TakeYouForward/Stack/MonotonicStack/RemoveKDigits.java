package TakeYouForward.Stack.MonotonicStack;

import java.util.Stack;

class RemoveKDigits {

    public static void main(String[] args) {
        String heights = "405678";
        System.out.println("removeKdigits" + removeKdigits(heights, 3));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        //Construct String builder
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}