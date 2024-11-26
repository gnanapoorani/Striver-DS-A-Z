package TakeYouForward.Stack.MonotonicStack;

import TakeYouForward.Pair;

import java.util.Stack;

class SumOfSubArrayRanges {

    public static void main(String[] args) {
        int[] arr = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(arr));
    }

    public static int subArrayRanges(int[] arr) {
        int n = arr.length;
        Stack<Pair<Integer, Integer>> st_PLE = new Stack<>();
        Stack<Pair<Integer, Integer>> st_NLE = new Stack<>();
        int[] PLE = new int[n];
        int[] NLE = new int[n];
        int[] PGE = new int[n];
        int[] NGE = new int[n];
        /**PLE*/
        for (int i = 0; i < n; i++) {
            while (!st_PLE.isEmpty() && st_PLE.peek().getKey() > arr[i]) {
                st_PLE.pop();
            }
            PLE[i] = (!st_PLE.isEmpty()) ? st_PLE.peek().getValue() : i;
            st_PLE.push(new Pair<>(arr[i], i));
        }

/**NLE*/


        for (int i = n - 1; i >= 0; i--) {
            while (!st_NLE.isEmpty() && st_NLE.peek().getKey() > arr[i]) {
                st_NLE.pop();
            }
            NLE[i] = (!st_NLE.isEmpty()) ? st_NLE.peek().getValue() - i :n-i;
            st_NLE.push(new Pair<>(arr[i], i));
        }

/**PGE*/


        st_PLE.clear();
        for (int i = 0; i < n; i++) {
            while (!st_PLE.isEmpty() && st_PLE.peek().getKey() <= arr[i]) {
                st_PLE.pop();
            }
            PGE[i] = (!st_PLE.isEmpty()) ? st_PLE.peek().getValue() : i;
            st_PLE.push(new Pair<>(arr[i], i));
        }
        /**NGE*/
        st_NLE.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st_NLE.isEmpty() && st_NLE.peek().getKey() < arr[i]) {
                st_NLE.pop();
            }
            NGE[i] = (!st_NLE.isEmpty()) ? st_NLE.peek().getValue() - i :n-i;
            st_NLE.push(new Pair<>(arr[i], i));
        }

        int sum = 0;
        int mod = 1000000007;
        for (int k = 0; k < arr.length; k++) {
            sum += arr[k] * ((NGE[k] * PGE[k])-(NLE[k] * PLE[k])) % mod;
        }
        return sum ;
    }

}
