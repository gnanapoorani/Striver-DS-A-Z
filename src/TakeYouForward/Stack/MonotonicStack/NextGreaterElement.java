package TakeYouForward.Stack.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {8,4,6,2,3};
        int[] result1 = nextGreaterElement(nums1, nums2);
        int[] result = nextGreaterElement2(nums2);
        int[] result3 = finalPrices(nums2);
        int[] result4 = count_NGEs(8,nums2,2,nums1);

        for (int num : result4) {
            System.out.println(num);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nge = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        for (int j = nums2.length - 1; j >= 0; j--) {
            while (!st.isEmpty() && st.peek() < nums2[j]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                map.put(nums2[j], st.peek());
            }
            st.push(nums2[j]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nge[i] = map.getOrDefault(nums1[i], -1);
        }
        return nge;
    }

    public static int[] nextGreaterElement2(int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) {
                    nge[i] = st.peek();
                } else {
                    nge[i] = -1;
                }
            }
            st.push(nums2[i % n]);
        }
        return nge;
    }

    public static int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for (int i=prices.length-1;i>=0;i--) {
            while (!st.isEmpty() && st.peek()> prices[i]) {
                st.pop();
            }
            if(!st.isEmpty()){
                result[i]=prices[i]-st.peek();
            }else{
                result[i]=prices[i];
            }
            st.push(prices[i]);
        }
        return result;
    }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
       int[] result= new int[N];


       return  result;

    }
}