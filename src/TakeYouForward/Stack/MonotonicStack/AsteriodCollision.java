package TakeYouForward.Stack.MonotonicStack;

import java.util.Stack;

class AsteriodCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,2};
        int[] result = asteroidCollision(asteroids);
        for (int b : result) {
            System.out.println(b);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}