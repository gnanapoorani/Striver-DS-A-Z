package TakeYouForward.Strings.Easy;

import java.util.Stack;

class RemoveOutermostParanthesis {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stringStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                stringStack.pop();
                if (stringStack.size() > 0) {
                    result.append(c);
                }

            } else {
                if (stringStack.size() > 0) {
                    result.append(c);
                }
                stringStack.push(c);
            }
        }
        return result.toString();
    }

}