package TakeYouForward.Stack.MonotonicStack;


import java.util.ArrayDeque;
import java.util.Deque;

class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] asteroids = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(asteroids, 3);
        for (int b : result) {
            System.out.println(b);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] results = new int[nums.length - k + 1];
        int r = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                results[r] = nums[deque.peek()];
                r++;
            }
        }

        return results;
    }
}