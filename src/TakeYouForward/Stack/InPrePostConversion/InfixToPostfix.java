package TakeYouForward.Stack.InPrePostConversion;

import java.util.Stack;

class InfixToPostFix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    static int precedence(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> st = new Stack<>();
        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            } else {
                if (ch == '(') {
                    st.push(ch);
                } else {
                    if (ch == ')') {
                        while (st.peek() != '(') {
                            result += st.pop();
                        }
                        st.pop();
                    } else {
                        while(!st.isEmpty() && precedence(ch)<= precedence(st.peek())){
                          result+=st.pop();
                        }
                       st.push(ch);
                    }
                }

            }
        }
        while(!st.isEmpty()){
           result+=st.pop();
        }
        return result;
    }
}