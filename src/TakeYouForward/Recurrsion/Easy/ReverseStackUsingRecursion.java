package TakeYouForward.Recurrsion.Easy;

import java.util.Stack;

class PowerImplsds23{
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>();
        numberStack.push(-3);
        numberStack.push(14);
        numberStack.push(18);
        numberStack.push(-5);
        numberStack.push(30);
        System.out.println(numberStack);
        reverseStack(numberStack);

        System.out.println(numberStack);
    }

    public static void reverseStack(Stack<Integer> numberStack) { //[-3, 14, 18, -5, 30]
        if (numberStack.isEmpty()) {
            return;
        }
        int popNumber = numberStack.pop();
        reverseStack(numberStack);
        insert(numberStack, popNumber);
    }

    public static void insert(Stack<Integer> numberStack, int number) {//[30, -5, 18, 14, -3]
        if (numberStack.isEmpty()) {
            numberStack.push(number);
            return;
        }
        if (!numberStack.isEmpty()) {
            int popValue = numberStack.pop();
            insert(numberStack, number);
            numberStack.push(popValue);
        }
    }
}