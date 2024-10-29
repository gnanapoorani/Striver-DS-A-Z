package TakeYouForward.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StackUsingArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int goal = 0;
        System.out.println(isValid("()()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> paranthesisStack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                paranthesisStack.push(ch);
            } else {
                if (paranthesisStack.isEmpty()) {
                    return false;
                }
                char topElem = paranthesisStack.pop();
                if (topElem == '(' && ch == ')' || topElem == '{' && ch == '}' || topElem == '[' && ch == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return paranthesisStack.isEmpty();

    }

    Queue<Integer> queue;

    public StackUsingArray() {
        this.queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public void pop() {
        queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyQueue {
    Stack<Integer> queueUsingStack;

    public MyQueue() {
        queueUsingStack = new Stack<>();
    }

    public void push(int x) {
        queueUsingStack.add(x);
        Stack<Integer> temp = new Stack<>();
        while (!queueUsingStack.isEmpty()) {
            temp.push(queueUsingStack.pop());
        }
        while (!temp.isEmpty()) {
            queueUsingStack.push(temp.pop());
        }
    }

    public int pop() {
        return queueUsingStack.pop();
    }

    public int peek() {
        return queueUsingStack.peek();
    }

    public boolean empty() {
        return queueUsingStack.isEmpty();
    }
}

class MyStack {
    class StackNode {
        int data;
        StackNode next;

        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode element = new StackNode(a);
        top = element.next;
        top = element;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if (top == null) {
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }
}

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }
}
