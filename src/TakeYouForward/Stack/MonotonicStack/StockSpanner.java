package TakeYouForward.Stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    static Deque<int[]> stack;
    public void StockSpanner() {
        stack = new ArrayDeque<>();
    }
    public static void main(String[] args) {
        System.out.println("next" + next(9));
    }

    public static int next(int price) {
        int res = 1;

        while(!stack.isEmpty() && price >= stack.peekFirst()[0]) {
            res += stack.removeFirst()[1];
        }

        stack.addFirst(new int[]{price, res});
        return res;
    }
}