package TakeYouForward.Stack.InPrePostConversion;

class prefixToInfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }
        }
        return result;
    }
    }