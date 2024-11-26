package TakeYouForward.Heaps.Basic;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public static void main(String[] args) {
        int a[]
                = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int k = 3;
        System.out.print(k + " largest elements are : ");
        // Function Call
//        kLargest(a, k);
        System.out.println(findKthLargest(a, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int num : nums) {
            pq.add(num);
        }

        while(k> 1) {
            pq.poll();
            k--;
        }

        return pq.peek();
    }

    // Function to find k largest array element
    static void kLargest(int a[], int k) {
        int n = a.length;
        // Implementation using
        // a Priority Queue
        PriorityQueue<Integer> pq
                = new PriorityQueue<Integer>();

        for (int i = 0; i < n; ++i) {
            // Insert elements into
            // the priority queue
            pq.add(a[i]);

            // If size of the priority
            // queue exceeds k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Print the kth largest element
        while (pq.size() > 1) {
            pq.poll();
            k--;
        }
        System.out.print(pq.peek() + " ");
    }
}
