import java.util.Stack;

class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>();
        numberStack.push(-3);
        numberStack.push(14);
        numberStack.push(18);
        numberStack.push(-5);
        numberStack.push(30);
        System.out.println(numberStack);
        sortStack(numberStack);
        System.out.println(numberStack);


    }

    public static void sortStack(Stack<Integer> numberStack) {
        if (numberStack.isEmpty()) {
            return;
        }
        int popNumber = numberStack.pop();
        sortStack(numberStack);
        insert(numberStack, popNumber);

    }

    public static void insert(Stack<Integer> numberStack, int valueToBeInserted) {//[30, -5, 18, 14, -3]
        if (numberStack.isEmpty() ) {
            numberStack.push(valueToBeInserted);
            return;
        }
        if (!numberStack.isEmpty()) {
            int topValue = numberStack.peek();

            if (valueToBeInserted < topValue) {
                int popValue = numberStack.pop();
                insert(numberStack, valueToBeInserted);
                numberStack.push(popValue);
            } else {
                numberStack.push(valueToBeInserted);
            }
        }
    }


}