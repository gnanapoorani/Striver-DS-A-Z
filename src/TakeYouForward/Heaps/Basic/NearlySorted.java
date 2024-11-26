package TakeYouForward.Heaps.Basic;

import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {
        int a[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        nearlySorted(a, k);
    }

    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
