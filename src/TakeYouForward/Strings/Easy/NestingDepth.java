package TakeYouForward.Strings.Easy;

import java.util.Stack;

class RotateStringNew {
    public static void main(String[] args) {

        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int maxDepth(String s) {
        int maxCount = 0, count = 0;
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            count=0;
            if (c == '(') {
                characterStack.push(c);
            } else if (c == ')') {
                if (characterStack.size() != 0) {
                    characterStack.pop();
                    count++;
                    count+=characterStack.size();
                    if (maxCount < count) {
                        maxCount = count;
                    }
                }
            }

        }
        return maxCount;
    }

    public static int maxDepth1(String s) {
        int max = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == ')'){
                max = Math.max(max,count);
                count--;
            }
            if(c =='(')
                count++;
        }
        return max;

    }

}